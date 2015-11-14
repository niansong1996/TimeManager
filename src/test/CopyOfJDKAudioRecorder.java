package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class CopyOfJDKAudioRecorder extends Thread {
	// �a��TargetDataLinee��׃��m_targetdataline
	static TargetDataLine m_targetdataline;

	// ͸�^TargetDataLine����(�^����DataLine)�c��Ч����ͨ targetĿ��

	// �a��AudioFileFormat.Typee��׃��m_targetType Format��ʽ
	static AudioFileFormat.Type m_targetType;

	// �a��AudioInputStreame��׃��m_audioInputStream stream��
	static AudioInputStream m_audioInputStream;

	static File m_outputFile;// �a��Filee��׃�� m_outputFile

	static ByteArrayOutputStream bos = new ByteArrayOutputStream();

	static byte[] buf;

	static boolean m_bRecording;// �������õ����ֺ��� True,False

	public CopyOfJDKAudioRecorder(TargetDataLine line,
			AudioFileFormat.Type targetType, File file) {
		m_targetdataline = line;
		m_audioInputStream = new AudioInputStream(line);
		m_targetType = targetType;
		m_outputFile = file;
	}

	public static void AudioRecorder() {
		String Filename = "d:/JDKAudioRecord.wav ";
		File outputFile = new File(Filename);

		// �҂�һ�_ʼ��������ʽ�eָ�����n�ęn����
		// JDKAudioRecorder.wav
		// String Filename = "JDKAudioRecord.wav ";
		// ����ָ����n���Y�ϊA,�A�O������ͬ���Y�ϊA
		// File outputFile = new File(Filename);

		AudioFormat audioFormat = null;

		// audioFormat = new
		// AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100.0F, 16, 2, 4,
		// 44100.0F, false);
		audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F,
				8, 1, 1, 44100F, false);
		// �ف��O����ȡ����Ч�n�Č���
		// audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
		// 44100.0F, 16, 2, 4, 44100.0F, false);

		DataLine.Info info = new DataLine.Info(TargetDataLine.class,
				audioFormat);
		TargetDataLine targetDataLine = null;

		// Ȼ��͸�^TargetDataLine����(�^����DataLine)�c��Ч����ͨ
		// DataLine.Info info = new DataLine.Info(TargetDataLine.class,
		// audioFormat);
		// ����������̎��,�����b�ó��e���������،���������ܟo�������Еr,��ʽ�����Kֹ

		try {
			targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			targetDataLine.open(audioFormat);// try{ }���ܰl������Ĕ���

		} catch (LineUnavailableException e)// catch{ }̎����

		{
			System.out.println("�o�����,���ʧ�� ");
			e.printStackTrace();
			System.exit(-1);
		}

		AudioFileFormat.Type targetType = AudioFileFormat.Type.AU;
		CopyOfJDKAudioRecorder recorder = null;

		recorder = new CopyOfJDKAudioRecorder(targetDataLine, targetType,
				outputFile);
		recorder.start();
	}

	public void start() {
		m_targetdataline.start();
		super.start();
		System.out.println("recording...");
	}

	public static void stopRecording() {
		m_targetdataline.stop();
		m_targetdataline.close();
		m_bRecording = false;
		buf = bos.toByteArray();
		System.out.println("stopped.");
	}

	public void run() {
		try {
			// AudioSystem.write(m_audioInputStream, m_targetType,
			// m_outputFile);
			AudioSystem.write(m_audioInputStream, m_targetType, bos);
			System.out.println("after   write() ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 public static void main(String args[]) {
		CopyOfJDKAudioRecorder.AudioRecorder();
	}

}
