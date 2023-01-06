package com.example.mycloudmusicandroidjava.modle;
/*所有模型父类*/
public class Common extends BaseId {
    /*创建时间*/
    private String createAt;
    /*更新时间*/
    private String updateAt;

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
