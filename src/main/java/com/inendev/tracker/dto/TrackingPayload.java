package com.inendev.tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class TrackingPayload {
    @JsonProperty("@type")
    private String type;

    @JsonProperty("end_device_ids")
    private DeviceIds endDeviceIds;

    @JsonProperty("correlation_ids")
    private List<String> correlationIds = new ArrayList<>();

    @JsonProperty("received_at")
    private String receivedAt;

    @JsonProperty("uplink_message")
    private UplinkMessage uplinkMessage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DeviceIds getEndDeviceIds() {
        return endDeviceIds;
    }

    public void setEndDeviceIds(DeviceIds endDeviceIds) {
        this.endDeviceIds = endDeviceIds;
    }

    public List<String> getCorrelationIds() {
        return correlationIds;
    }

    public void setCorrelationIds(List<String> correlationIds) {
        this.correlationIds = correlationIds;
    }

    public String getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(String receivedAt) {
        this.receivedAt = receivedAt;
    }

    public UplinkMessage getUplinkMessage() {
        return uplinkMessage;
    }

    public void setUplinkMessage(UplinkMessage uplinkMessage) {
        this.uplinkMessage = uplinkMessage;
    }

    @Override
    public String toString() {
        return "TrackingPayload{" +
                "type='" + type + '\'' +
                ", endDeviceIds=" + endDeviceIds +
                ", correlationIds=" + correlationIds +
                ", receivedAt='" + receivedAt + '\'' +
                ", uplinkMessage=" + uplinkMessage +
                '}';
    }

    public static class UplinkMessage {
        @JsonProperty("session_key_id")
        private String sessionKeiId;
        @JsonProperty("f_port")
        private Long fPort;
        @JsonProperty("f_cnt")
        private Long fCnt;
        @JsonProperty("frm_payload")
        private String frmPayload;
        @JsonProperty("decoded_payload")
        private DecodedPayload decodedPayload;
        @JsonProperty("rx_metadata")
        private List<RxMetadata> rxMetadata = new ArrayList<>();
        private Settings settings;
        @JsonProperty("received_at")
        private String receivedAt;
        @JsonProperty("consumed_airtime")
        private String consumedAirtime;
        @JsonProperty("version_ids")
        private VersionIds versionIds;
        @JsonProperty("network_ids")
        private NetworkIds networkIds;

        @Override
        public String toString() {
            return "UplinkMessage{" +
                    "sessionKeiId='" + sessionKeiId + '\'' +
                    ", fPort=" + fPort +
                    ", fCnt=" + fCnt +
                    ", frmPayload='" + frmPayload + '\'' +
                    ", decodedPayload=" + decodedPayload +
                    ", rxMetadata=" + rxMetadata +
                    ", settings=" + settings +
                    ", receivedAt='" + receivedAt + '\'' +
                    ", consumedAirtime='" + consumedAirtime + '\'' +
                    ", versionIds=" + versionIds +
                    ", networkIds=" + networkIds +
                    '}';
        }

        public String getSessionKeiId() {
            return sessionKeiId;
        }

        public void setSessionKeiId(String sessionKeiId) {
            this.sessionKeiId = sessionKeiId;
        }

        public Long getfPort() {
            return fPort;
        }

        public void setfPort(Long fPort) {
            this.fPort = fPort;
        }

        public Long getfCnt() {
            return fCnt;
        }

        public void setfCnt(Long fCnt) {
            this.fCnt = fCnt;
        }

        public String getFrmPayload() {
            return frmPayload;
        }

        public void setFrmPayload(String frmPayload) {
            this.frmPayload = frmPayload;
        }

        public DecodedPayload getDecodedPayload() {
            return decodedPayload;
        }

        public void setDecodedPayload(DecodedPayload decodedPayload) {
            this.decodedPayload = decodedPayload;
        }

        public List<RxMetadata> getRxMetadata() {
            return rxMetadata;
        }

        public void setRxMetadata(List<RxMetadata> rxMetadata) {
            this.rxMetadata = rxMetadata;
        }

        public Settings getSettings() {
            return settings;
        }

        public void setSettings(Settings settings) {
            this.settings = settings;
        }

        public String getReceivedAt() {
            return receivedAt;
        }

        public void setReceivedAt(String receivedAt) {
            this.receivedAt = receivedAt;
        }

        public String getConsumedAirtime() {
            return consumedAirtime;
        }

        public void setConsumedAirtime(String consumedAirtime) {
            this.consumedAirtime = consumedAirtime;
        }

        public VersionIds getVersionIds() {
            return versionIds;
        }

        public void setVersionIds(VersionIds versionIds) {
            this.versionIds = versionIds;
        }

        public NetworkIds getNetworkIds() {
            return networkIds;
        }

        public void setNetworkIds(NetworkIds networkIds) {
            this.networkIds = networkIds;
        }
    }

    public static class VersionIds {
        @JsonProperty("brand_id")
        private String brandId;
        @JsonProperty("model_id")
        private String modelId;
        @JsonProperty("hardware_version")
        private String hardwareVersion;
        @JsonProperty("firmware_version")
        private String firmwareVersion;
        @JsonProperty("band_id")
        private String bandId;

        @Override
        public String toString() {
            return "VersionIds{" +
                    "brandId='" + brandId + '\'' +
                    ", modelId='" + modelId + '\'' +
                    ", hardwareVersion='" + hardwareVersion + '\'' +
                    ", firmwareVersion='" + firmwareVersion + '\'' +
                    ", bandId='" + bandId + '\'' +
                    '}';
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getModelId() {
            return modelId;
        }

        public void setModelId(String modelId) {
            this.modelId = modelId;
        }

        public String getHardwareVersion() {
            return hardwareVersion;
        }

        public void setHardwareVersion(String hardwareVersion) {
            this.hardwareVersion = hardwareVersion;
        }

        public String getFirmwareVersion() {
            return firmwareVersion;
        }

        public void setFirmwareVersion(String firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
        }

        public String getBandId() {
            return bandId;
        }

        public void setBandId(String bandId) {
            this.bandId = bandId;
        }
    }

    public static class NetworkIds {
        @JsonProperty("net_id")
        private String netId;
        @JsonProperty("tenant_id")
        private String tenantId;
        @JsonProperty("cluster_id")
        private String clusterId;
        @JsonProperty("cluster_address")
        private String clusterAddress;

        public String getNetId() {
            return netId;
        }

        public void setNetId(String netId) {
            this.netId = netId;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getClusterId() {
            return clusterId;
        }

        public void setClusterId(String clusterId) {
            this.clusterId = clusterId;
        }

        public String getClusterAddress() {
            return clusterAddress;
        }

        public void setClusterAddress(String clusterAddress) {
            this.clusterAddress = clusterAddress;
        }
    }

    public static class Settings {
        @JsonProperty("data_rate")
        private DataRate dataRate;
        private String frequency;
        private Long timestamp;
        private String time;

        public DataRate getDataRate() {
            return dataRate;
        }

        public void setDataRate(DataRate dataRate) {
            this.dataRate = dataRate;
        }

        public String getFrequency() {
            return frequency;
        }

        public void setFrequency(String frequency) {
            this.frequency = frequency;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Settings{" +
                    "dataRate=" + dataRate +
                    ", frequency='" + frequency + '\'' +
                    ", timestamp=" + timestamp +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

    public static class DataRate {
        private Lora lora;

        public Lora getLora() {
            return lora;
        }

        public void setLora(Lora lora) {
            this.lora = lora;
        }
    }

    public static class Lora {
        private Long bandwidth;
        @JsonProperty("spreading_factor")
        private Long spreadingFactor;
        @JsonProperty("coding_rate")
        private String codingRate;

        public Long getBandwidth() {
            return bandwidth;
        }

        public void setBandwidth(Long bandwidth) {
            this.bandwidth = bandwidth;
        }

        public Long getSpreadingFactor() {
            return spreadingFactor;
        }

        public void setSpreadingFactor(Long spreadingFactor) {
            this.spreadingFactor = spreadingFactor;
        }

        public String getCodingRate() {
            return codingRate;
        }

        public void setCodingRate(String codingRate) {
            this.codingRate = codingRate;
        }
    }

    public static class DecodedPayload {
        private String addr;
        private Long alarm;
        private Double batV;
        private Long major;
        private Long minor;
        private Long rssi;
        @JsonProperty("step_count")
        private Long stepCount;
        private String uuid;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public Long getAlarm() {
            return alarm;
        }

        public void setAlarm(Long alarm) {
            this.alarm = alarm;
        }

        public Double getBatV() {
            return batV;
        }

        public void setBatV(Double batV) {
            this.batV = batV;
        }

        public Long getMajor() {
            return major;
        }

        public void setMajor(Long major) {
            this.major = major;
        }

        public Long getMinor() {
            return minor;
        }

        public void setMinor(Long minor) {
            this.minor = minor;
        }

        public Long getRssi() {
            return rssi;
        }

        public void setRssi(Long rssi) {
            this.rssi = rssi;
        }

        public Long getStepCount() {
            return stepCount;
        }

        public void setStepCount(Long stepCount) {
            this.stepCount = stepCount;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }

    private static class RxMetadata {
        @JsonProperty("gateway_ids")
        private GatewayId gatewayIds;
        private String time;
        private Long timestamp;
        private Long rssi;
        @JsonProperty("channel_rssi")
        private Long channelRssi;
        private Long snr;
        @JsonProperty("frequency_offset")
        private String frequencyOffset;
        @JsonProperty("uplink_token")
        private String uplinkToken;
        @JsonProperty("channel_index")
        private Long channelIndex;
        @JsonProperty("received_at")
        private String receivedAt;

        public GatewayId getGatewayIds() {
            return gatewayIds;
        }

        public void setGatewayIds(GatewayId gatewayIds) {
            this.gatewayIds = gatewayIds;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public Long getRssi() {
            return rssi;
        }

        public void setRssi(Long rssi) {
            this.rssi = rssi;
        }

        public Long getChannelRssi() {
            return channelRssi;
        }

        public void setChannelRssi(Long channelRssi) {
            this.channelRssi = channelRssi;
        }

        public Long getSnr() {
            return snr;
        }

        public void setSnr(Long snr) {
            this.snr = snr;
        }

        public String getFrequencyOffset() {
            return frequencyOffset;
        }

        public void setFrequencyOffset(String frequencyOffset) {
            this.frequencyOffset = frequencyOffset;
        }

        public String getUplinkToken() {
            return uplinkToken;
        }

        public void setUplinkToken(String uplinkToken) {
            this.uplinkToken = uplinkToken;
        }

        public Long getChannelIndex() {
            return channelIndex;
        }

        public void setChannelIndex(Long channelIndex) {
            this.channelIndex = channelIndex;
        }

        public String getReceivedAt() {
            return receivedAt;
        }

        public void setReceivedAt(String receivedAt) {
            this.receivedAt = receivedAt;
        }
    }

    public static class DeviceIds {
        @JsonProperty("device_id")
        private String deviceId;

        @JsonProperty("application_ids")
        private ApplicationIds applicationIds = new ApplicationIds();

        @JsonProperty("dev_eui")
        private String devEui;

        @JsonProperty("join_eui")
        private String joinEui;

        @JsonProperty("dev_addr")
        private String devAddr;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public ApplicationIds getApplicationIds() {
            return applicationIds;
        }

        public void setApplicationIds(ApplicationIds applicationIds) {
            this.applicationIds = applicationIds;
        }

        public String getDevEui() {
            return devEui;
        }

        public void setDevEui(String devEui) {
            this.devEui = devEui;
        }

        public String getJoinEui() {
            return joinEui;
        }

        public void setJoinEui(String joinEui) {
            this.joinEui = joinEui;
        }

        public String getDevAddr() {
            return devAddr;
        }

        public void setDevAddr(String devAddr) {
            this.devAddr = devAddr;
        }
    }

    public static class ApplicationIds {
        @JsonProperty("application_id")
        private String applicationId;

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }
    }

    public static class GatewayId {
        @JsonProperty("gateway_id")
        private String gatewayId;
        private String eui;

        public String getGatewayId() {
            return gatewayId;
        }

        public void setGatewayId(String gatewayId) {
            this.gatewayId = gatewayId;
        }

        public String getEui() {
            return eui;
        }

        public void setEui(String eui) {
            this.eui = eui;
        }
    }
}
