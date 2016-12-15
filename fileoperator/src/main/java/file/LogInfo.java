package file;

/**
 * @author WanChuanLai
 * @create 12/14/16.
 */
public class LogInfo {
    private String keyName;
    private Long processtime;
    private String logTime;
    private String type;
    private String uuid;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Long getProcesstime() {
        return processtime;
    }

    public void setProcesstime(Long processtime) {
        this.processtime = processtime;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @Override
    public String toString() {
        return "LogInfo{" +
                "keyName='" + keyName + '\'' +
                ", processtime=" + processtime +
                ", logTime='" + logTime + '\'' +
                ", type='" + type + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
