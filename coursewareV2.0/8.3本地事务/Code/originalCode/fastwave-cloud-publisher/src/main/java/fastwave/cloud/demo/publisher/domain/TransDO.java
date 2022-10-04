package fastwave.cloud.demo.publisher.domain;

import java.io.Serializable;

public class TransDO implements Serializable {

    private String id;
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
