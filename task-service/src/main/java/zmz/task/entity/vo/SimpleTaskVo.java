package zmz.task.entity.vo;

import lombok.Data;

@Data
public class SimpleTaskVo
{
    private Long id;

    private Long publicUserId;

    //south和north
    private String school;

    private String title;
    private String destination;
    private String productLocation;
    private Boolean isDaigou;
    private Integer daigouPrice;
    private Integer taskPrice;
    private String publicDate;

}
