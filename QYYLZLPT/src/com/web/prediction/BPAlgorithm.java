package com.web.prediction;

public class BPAlgorithm {
	
	public static void main(String[] args) throws Exception {
		double[] data={120,110,122,130,122,
				125,130,125,135,127,
				128,118,120,121,131};
		double[] result = htnHeartRate(data);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		double[] data1={7.4,7.8,8.5,7.9,9.0,
				7.8,8.8,8.2,8.3,8.4,
				8.2,8.1,8.5,8.1,8.2};
		double[] result1 = hplTC(data1);
		for (int i = 0; i < result1.length; i++) {
			System.out.println(result1[i]);
		}
		
	}
	
	/**
	 * �������15�ε���ֵ��Ȼ��Ԥ����������ֵ�����صĽ��Ϊ����Ϊ8�����飬
	 * �������ǰ��5��ֵΪ����5����ݣ�����3��ֵΪԤ�����3��ֵ
	 * ע�⣺���������ֵ����ΪС��1����������Ҫ��ʹ��ǰ�������СΪС��1����
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static double[] forecast(double[] data) throws IllegalArgumentException {
		if(data.length!=15){
			throw new IllegalArgumentException("Ԥ��ĳ�ʼ��ݸ���Ϊ15");
		}
		double[][] trainData = { { data[0], data[1], data[2], data[3], data[4] },
				{ data[1], data[2], data[3], data[4],data[5] },
				{ data[2], data[3], data[4], data[5], data[6] },
				{ data[3], data[4], data[5], data[6], data[7] },
				{ data[4], data[5], data[6], data[7], data[8] },
				{ data[5], data[6], data[7], data[8], data[9] },
				{ data[6], data[7], data[8], data[9], data[10] },
				{ data[7], data[8], data[9], data[10], data[11] } };

		double[][] targetData = { { data[5], data[6], data[7] },
				{ data[6], data[7], data[8] },
				{ data[7], data[8], data[9] },
				{ data[8], data[9], data[10] }, 
				{ data[9], data[10], data[11] },
				{ data[10], data[11], data[12] }, 
				{ data[11], data[12], data[13] },
				{ data[12], data[13], data[14] } };
		
		BPFactory.initialization(5, 55, 3);
		for (int i = 0; i < 1156; i++) {
			for (int j = 0; j < trainData.length; j++) {
				BPFactory.train(trainData[j], targetData[j]);
			}
		}
		
		double[] test = { data[10], data[11], data[12], data[13],data[14] };
		double[] forecastResault = BPFactory.test(test);

		double[] result=new double[8];
		for (int i = 0; i < 5; i++) {
			result[i]=test[i];
		}
		result[5]=forecastResault[0];
		result[6]=forecastResault[1];
		result[7]=forecastResault[2];
		
		return result;
	}
	/**
	 * Ѫ��:2-10 mmol/L��������ݵķ�Χ����С��100
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] gluBloodGlucose(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
	/**
	 * ����ѹ 80-200��������ݵķ�Χ����С��1000
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] htnSystolicPressure(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
	
	/**
	 * ����ѹ 50-130��������ݵķ�Χ����С��1000
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] htnDiastolicPressure(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
	/**
	 * ���� 30-120��������ݵķ�Χ����С��1000
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] htnHeartRate(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
	
	/**
	 * �ܵ��̴�ֵ:2.2-11.7��������ݵķ�Χ����С��100
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] hplTC(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
	/**
	 * ��������ֵ:0.5-1.7��������ݵķ�Χ����С��10
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] hplTG(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
	
	/**
	 * ���ܶ�֬���׵��̴�ֵ:1.16-1.42��������ݵķ�Χ����С��10
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] hplHDL(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
	/**
	 * ���ܶ�֬���׵��̴�ֵ:2.7-4.14,������ݵķ�Χ����С��10
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] hplLDL(double[] data) throws IllegalArgumentException{
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i]/1000;
		}
		double[] result=forecast(data);
		for (int i = 0; i < result.length; i++) {
			result[i]=result[i]*1000;
		}
		return result;
	}
}
