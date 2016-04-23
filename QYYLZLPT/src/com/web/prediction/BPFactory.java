package com.web.prediction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BPFactory {
	/**
	 * BP������Ԫ
	 */
	private static BP bp;
	
	/**
	 * ��ʼ��һ��ȫ�µ�bp������
	 * @param inputSize
	 * @param hiddenSize 
	 * @param outputSize
	 */
	public static void initialization(int inputSize,int hiddenSize,int outputSize) {
		bp=new BP(inputSize, hiddenSize, outputSize);
	}
	
	/**
	 * ���ļ�����ж�ȡbp������
	 * @param file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void initialization(File file) throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream si = new ObjectInputStream(fi); 
		bp = (BP) si.readObject(); 
		si.close();
	}
	
	/**
	 * ��Ŀǰ�������索����ָ���ļ�
	 * @param file
	 * @throws IOException
	 */
	public static void save(File file) throws IOException {
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream so = new ObjectOutputStream(fo);
		so.writeObject(bp);
		so.close();
	}
	
	/**
	 * ѵ��BP������
	 * @param trainData
	 * @param target
	 */
	public static void train(double[] trainData, double[] target) {
		bp.train(trainData, target);
	}
	
	/**
	 * Ҫ��bp�����緵��Ԥ��ֵ
	 * @param inData
	 * @return
	 */
	public static double[] test(double[] inData) {
		return bp.test(inData);
	}
}
