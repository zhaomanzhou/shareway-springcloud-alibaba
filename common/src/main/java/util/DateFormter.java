package util;


import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormter
{
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public String fomat(Date d)
    {
        return sdf.format(d);
    }
}
