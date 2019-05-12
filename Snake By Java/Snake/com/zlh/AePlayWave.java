<<<<<<< HEAD
package com.zlh;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AePlayWave extends Thread{
	private String filename;
	private final int EXTERNAL_BUFFER_SIZE=524288;// 128Kb
	
	public AePlayWave(String wavfile) {
		filename=wavfile;
	}
	
	public void run() {
		File soundFile=new File(filename);
		AudioInputStream audioInputStream=null;
		try {
			audioInputStream=AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioFormat format=audioInputStream.getFormat();
		SourceDataLine auLine=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
		
		try {
			auLine=(SourceDataLine) AudioSystem.getLine(info);
			auLine.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		auLine.start();
		int nBytesRead=0;
		byte[] abData=new byte[EXTERNAL_BUFFER_SIZE];
		
		try {
			while(nBytesRead!=-1) {
				nBytesRead=audioInputStream.read(abData	, 0, abData.length);
				if(nBytesRead>=0) {
					auLine.write(abData, 0, nBytesRead);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		} finally {
			auLine.drain();
			auLine.close();
		}
	}
}








=======
package com.zlh;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AePlayWave extends Thread{
	private String filename;
	private final int EXTERNAL_BUFFER_SIZE=524288;// 128Kb
	
	public AePlayWave(String wavfile) {
		filename=wavfile;
	}
	
	public void run() {
		File soundFile=new File(filename);
		AudioInputStream audioInputStream=null;
		try {
			audioInputStream=AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioFormat format=audioInputStream.getFormat();
		SourceDataLine auLine=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
		
		try {
			auLine=(SourceDataLine) AudioSystem.getLine(info);
			auLine.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		auLine.start();
		int nBytesRead=0;
		byte[] abData=new byte[EXTERNAL_BUFFER_SIZE];
		
		try {
			while(nBytesRead!=-1) {
				nBytesRead=audioInputStream.read(abData	, 0, abData.length);
				if(nBytesRead>=0) {
					auLine.write(abData, 0, nBytesRead);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		} finally {
			auLine.drain();
			auLine.close();
		}
	}
}








>>>>>>> second commit
