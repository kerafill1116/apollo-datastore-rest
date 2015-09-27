package org.surfnet.oaaas.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Response representing the statistics for the entire database
 *
 */
@XmlRootElement
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class StatisticsResponse {

    private List<ResourceServerStat> resourceServers;

    public StatisticsResponse() {}
    public StatisticsResponse(List<ResourceServerStat> resourceServers) {
        this.resourceServers = resourceServers;
    }

    public static class ResourceServerStat {
        private String name;
        private String description;
        private List<ClientStat> clients;
        public ResourceServerStat() {}
        public ResourceServerStat(String name, String description,List<ClientStat> clients) {
            this.name = name;
            this.description = description;
            this.clients = clients;
        }
        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public List<ClientStat> getClients() {
            return clients;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public void setClients(List<ClientStat> clients) {
            this.clients = clients;
        }
    }

    public static class ClientStat {
        private String name;
        private String description;
        private long tokenCount;

        public ClientStat() {}
        public ClientStat(String name, String description, Number tokenCount) {
            this.name = name;
            this.description = description;
            this.tokenCount = tokenCount != null ? tokenCount.longValue() : 0L;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public long getTokenCount() {
            return tokenCount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTokenCount(long tokenCount) {
            this.tokenCount = tokenCount;
        }
    }

    public void setResourceServers(List<ResourceServerStat> resourceServers) {
        this.resourceServers = resourceServers;
    }

    public List<ResourceServerStat> getResourceServers() {
        return resourceServers;
    }
}
