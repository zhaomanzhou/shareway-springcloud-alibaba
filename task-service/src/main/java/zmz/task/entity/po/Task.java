package zmz.task.entity.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class Task {
    private Long id;

    private Long publicUserId;

    private String school;

    private String title;

    private String content;

    private String tel;

    private String destination;

    private String productLocation;

    private String comment;

    private Byte isDaigou;

    private BigDecimal daigouPrice;

    private BigDecimal taskPrice;

    private Date publicDate;

    private Date modifDate;

    private Date expireDate;

}