package zmz.entity.po;

import java.util.Date;

public class TaskUser {
    private Long id;

    private Long taskid;

    private Long publicUserId;

    private Long getUserId;

    private Byte publicStatus;

    private Byte getStatus;

    private Date createTimne;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getPublicUserId() {
        return publicUserId;
    }

    public void setPublicUserId(Long publicUserId) {
        this.publicUserId = publicUserId;
    }

    public Long getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(Long getUserId) {
        this.getUserId = getUserId;
    }

    public Byte getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(Byte publicStatus) {
        this.publicStatus = publicStatus;
    }

    public Byte getGetStatus() {
        return getStatus;
    }

    public void setGetStatus(Byte getStatus) {
        this.getStatus = getStatus;
    }

    public Date getCreateTimne() {
        return createTimne;
    }

    public void setCreateTimne(Date createTimne) {
        this.createTimne = createTimne;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}