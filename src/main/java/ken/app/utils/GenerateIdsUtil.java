package ken.app.utils;


import java.lang.management.ManagementFactory;
import java.util.Random;
import java.util.UUID;

/**
 * @Package: com.thfund.common.utils
 * @Title: GenerateIdsUtil.java
 * @Description: 生成各类业务ID
 * @date 2015年9月1日 下午11:43:02
 * @version V1.0
 **/
public class GenerateIdsUtil {
	private static int pid = Integer.valueOf(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

	private static int incrementGlobal = 0;
	private static long incrementGlobalID = 0;

	/**
	 * 带自定义前缀的ID生成
	 * 
	 * @param prefixKey
	 *            自定义的0-7位前缀
	 * @param
	 * @return
	 */
	public static String generateId(String prefixKey) {
		return prefixKey + generateId();
	}

	
	
	private static synchronized int getIncrement() {
		if (incrementGlobal == 99) {
			incrementGlobal = 0;
		}
		return ++incrementGlobal;
	}
	
	private static synchronized long getIncrementUUID() {
		if (incrementGlobalID == 99999) {
			incrementGlobalID = 0;
		}
		return ++incrementGlobalID;
	}

	/**
	 * ID生成器,6位IP4(CD段)左补0+13位时间戳+5位循环(00001-99999)左补0
	 * 
	 * @param ip
	 * @return
	 */
	public static synchronized String generateId() {
		String increment = String.format("%02d", getIncrement());

		String timeStr = DateUtil.formatDateTime("yyyyMMddHHmmssSSS");

		StringBuilder builder = new StringBuilder(timeStr);


		//builder.append(String.format("%03d", Integer.valueOf(ipSub[0])));
		//builder.append(String.format("%03d", Integer.valueOf(ipSub[1])));
		//builder.append(String.format("%05d", pid));
		builder.append(increment);

		String s = builder.toString();
		builder = null;
		return s;

	}
	
	public static synchronized String generateIdByUUID() {
		String increment = String.format("%05d", getIncrementUUID());
		String s = UUID.randomUUID().toString().replaceAll("-", "")+increment;
		return s;
	}
	

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<1000;i++) {
			System.out.println(generateIdByUUID());
		}
		for(int i =0;i<100;i++) {
			System.out.println(getRandomString(12));
		}
	}

	/**
	 * 获取指定长度随机字符串
	 *
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
				case 0:
					result = Math.round(Math.random() * 25 + 65);
					sb.append(String.valueOf((char) result));
					break;
				case 1:
					result = Math.round(Math.random() * 25 + 97);
					sb.append(String.valueOf((char) result));
					break;
				case 2:
					sb.append(String.valueOf(new Random().nextInt(10)));
					break;
			}
		}
		return sb.toString();
	}

}
