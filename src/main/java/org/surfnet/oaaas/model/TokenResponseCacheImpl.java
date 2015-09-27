package org.surfnet.oaaas.model;

import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TokenResponseCacheImpl implements TokenResponseCache {

    private Map<String, CacheEntry> cache = new ConcurrentHashMap<String, CacheEntry>();
    private int maxSize;
    private long expireTime;

    public TokenResponseCacheImpl(int maxSize, long expireTimeSeconds) {
        this.maxSize = maxSize;
        this.expireTime = expireTimeSeconds * 1000;
        invariant();
    }

    private void invariant() {
        Validate.isTrue(maxSize > 0, "Maxsize must be greater then 0");
        Validate.isTrue(expireTime < ((1000 * 60 * 60 * 24) + 1), "Maximal expireTime is one day");
        Validate.isTrue(expireTime > 0, "ExpireTimeMilliseconds must be greater then 0");
    }

    @Override
    public VerifyTokenResponse getVerifyToken(String accessToken) {
        VerifyTokenResponse response = null;
        if (accessToken != null) {
            CacheEntry cacheEntry = cache.get(accessToken);
            if (cacheEntry != null) {
                if (isExpired(cacheEntry)) {
                    cache.remove(accessToken);
                } else {
                    response = cacheEntry.value;
                }
            }
        }
        return response;
    }

    private boolean isExpired(CacheEntry cacheEntry) {
        return cacheEntry.expireBy < System.currentTimeMillis();
    }

    @Override
    public void storeVerifyToken(String accessToken, VerifyTokenResponse tokenResponse) {
        if (accessToken != null && tokenResponse != null) {
            if (cache.size() == maxSize) {
                cleanUpCache();
            }
            cache.put(accessToken, new CacheEntry(tokenResponse, System.currentTimeMillis() + expireTime));
        }
    }

    private void cleanUpCache() {
        Set<Map.Entry<String, CacheEntry>> entries = cache.entrySet();
        long ago = Long.MAX_VALUE;
        String oldestKey = null;
        for (Map.Entry<String, CacheEntry> entry : entries) {
            if (isExpired(entry.getValue())) {
                cache.remove(entry.getKey());
            } else if (entry.getValue().expireBy < ago) {
                oldestKey = entry.getKey();
                ago = entry.getValue().expireBy;
            }
        }
        if (oldestKey != null) {
            cache.remove(oldestKey);
        }
    }

    private class CacheEntry {
        private VerifyTokenResponse value;
        private long expireBy;

        CacheEntry(VerifyTokenResponse verifyTokenResponse, long expireBy) {
            this.value = verifyTokenResponse;
            this.expireBy = expireBy;
        }
    }
}
