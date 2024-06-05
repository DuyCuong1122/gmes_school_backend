package vn.gmestoken.core.utils;

public class AtributeFixValues {
	public static boolean SCHEDULE_SHOWPROGRESS = false; //Hiện tiến độ và dự báo ở biểu đồ kế hoạch
	public static long ATTR_COLOR = 4; // màu
	public static long ATTR_SIZE = 30; // cỡ sản phẩm
	public static long ATTR_SIZEWIDTH = 36; // cỡ khổ nguyên liệu
	public static long ATTR_FABRIC = 37; // thành phần vải
	public static long ATTR_TEX = 42; // Tex chi
	public static int orgtype_factory = 13;

	public static long value_color_all = 148;
	public static long value_size_all = 152;
	public static long value_sizewidth_all = 155;
	public static long role_id_admin = 4;
	public static String folder_upload = "gmesdha_upload";
	
	public static final String tkkey = "password";
    public static final String issuer = "auth0";
    public static final int appid = 100;
    public static final long validityInMilliseconds = 4*60*60*1000;//7200000; // 2h
    public static final String url_image = "http://gpay.vn:8181/static/user/";
	
//    public static String folder_image = "http://27.71.231.154:8080/gmesdha_upload/product/";//DHA
//    public static String folder_image = "http://gpay.vn:8090/gmesdha_upload/product/";//GSmart

	// DHA
//	public static String url_authen = "http://localhost:8081";// DHA
//	public static String url_jitin = "http://localhost:8080/jitindha";
//	public static String folder_image = "http://27.71.231.154:8080/gmesdha_upload/product/";// DHA
//	public static String url_timesheet = "http://localhost:6767";// DHA
	
	// DHA
	public static String url_authen = "http://27.71.231.154:8080";// DHA
	public static String url_jitin = "http://27.71.231.154:8080/jitindha";
	public static String folder_image = "http://27.71.231.154:8080/gmesdha_upload/product/";// DHA
	public static String url_timesheet = "http://localhost:6767";// DHA

	// GSmart
//	public static String url_authen = "http://localhost:8181";
//	public static String url_jitin = "http://gpay.vn:8090/jitin";
//	public static String folder_image = "http://gpay.vn:8090/gmesdha_upload/product/";
//	public static String url_timesheet = "http://localhost:6767";// DHA

	// Local
//	public static String url_authen = "http://gpay.vn:8181";// GSmart
//    public static String url_jitin = "http://localhost:8991/jitin";//JITIN
//    public static String url_gmes = "http://localhost:8990";//GMES
//	public static String folder_image = "http://localhost:8990/gmesdha_upload/product/";
//	public static String url_timesheet = "http://103.101.161.45:6767";// DHA
	
	//Remote DHA
//	public static String url_authen = "http://27.71.231.154:8081";// DHA
//	public static String url_jitin = "http://27.71.231.154:8080/jitindha";
//	public static String folder_image = "http://27.71.231.154:8080/gmesdha_upload/product/";// DHA
//	public static String url_timesheet = "http://27.71.231.154:6767";// DHA
}
