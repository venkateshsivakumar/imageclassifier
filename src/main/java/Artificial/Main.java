package Artificial;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Main {
	private static final int NUMBER_OF_INPUTS = 784;
    private static final int NUMBER_OF_ITERATIONS = 10;
	NeuralNetwork nn;
	double [] input= new double[NUMBER_OF_INPUTS]; 
	double[] output;
	double [] target = new double[2];
	int CAT = 0;
	int DOG = 1;
	double [] catData;
	double [] dogData;
	int totalData = 1000;
	Matrix mT = new Matrix(target.length, 1);
	public void trigger() {
		nn = new NeuralNetwork(NUMBER_OF_INPUTS, 64, 2);
		Matrix mIn = new Matrix(input.length,1);
		Matrix mT = new Matrix(target.length, 1);
		Random random = new Random();
		double[][] in;
		double[][] tar;
		
		for(int i=0; i<150000;i++) {	
		int key = random.nextInt(4);
		
		switch(key) {
			case 0:	input = new double[] {0,0};
		 			target = new double[] {0};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					//nn.train(in, tar);
					break;
					
			case 1:	input = new double[] {0,1};
		 			target = new double[] {1};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					//nn.train(in, tar);
					break;
			
			case 2:	input = new double[] {1,1};
		 			target = new double[] {0};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					//nn.train(in, tar);
					break;
					
			case 3: input = new double[] {1,0};
		 			target = new double[] {1};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					//nn.train(in, tar);
					break;
				
		}
		/*
		 * List<double[][]> inOutList = new ArrayList<double[][]>();
		 * Map<Integer,List<double[][]>> train = new HashMap<Integer,
		 * List<double[][]>>(); input = new double[] {1,0}; target = new double[] {1};
		 * double[][] in = Matrix.fromArray(input, mIn.data); double [][]tar =
		 * Matrix.fromArray(target, mT.data); inOutList.add(in); inOutList.add(tar);
		 * train.put(0,inOutList);
		 * 
		 * List<double[][]> inOutList1 = new ArrayList<double[][]>(); input = new
		 * double[] {0,1}; target = new double[] {1}; double[][] in1 =
		 * Matrix.fromArray(input, mIn.data); double[][] tar1 = Matrix.fromArray(target,
		 * mT.data); inOutList1.add(in1); inOutList1.add(tar1); train.put(1,inOutList1);
		 * 
		 * List<double[][]> inOutList2 = new ArrayList<double[][]>(); input = new
		 * double[] {0,0}; target = new double[] {0}; double[][] in2 =
		 * Matrix.fromArray(input, mIn.data); double[][] tar2 = Matrix.fromArray(target,
		 * mT.data); inOutList2.add(in2); inOutList.add(tar2); train.put(2,inOutList);
		 * 
		 * inOutList = new ArrayList<double[][]>(); input = new double[] {1,1}; target =
		 * new double[] {0}; double[][] in3 = Matrix.fromArray(input, mIn.data);
		 * double[][] tar3 = Matrix.fromArray(target, mT.data); inOutList.add(in3);
		 * inOutList.add(tar3); train.put(3,inOutList);
		 */
			 
			 
		
			//int key = random.nextInt(4);
			//System.out.print(key+",");
			//List<double[][]> val = train.get(key);
			
			
		}
		
		input = new double[] {1,0};
		double[][] inp = Matrix.fromArray(input, mIn.data);
		double[] out = nn.feedforward(inp);
		System.out.println(out[0]);
		
		input = new double[] {0,1};
		 inp = Matrix.fromArray(input, mIn.data);
		 out = nn.feedforward(inp);
		 System.out.println(out[0]);
		 
		input = new double[] {0,0};
		 inp = Matrix.fromArray(input, mIn.data);
		 out = nn.feedforward(inp);
		 System.out.println(out[0]);
		 
		input = new double[] {1,1};
		 inp = Matrix.fromArray(input, mIn.data);
		 out = nn.feedforward(inp);
		 System.out.println(out[0]);
	}
	
	public void prepareData(String[] category, byte[] data, int lable) {
		for(int i=0;i<totalData;i++) {
			int offset = i * NUMBER_OF_INPUTS;
			int threshold = (int)(.8 * totalData);
			if (i < threshold) {
			      //category.training[i] = data.bytes.subarray(offset, offset + len);
			     // category.training[i].label = label;
			    } else {
			      //category.testing[i - threshold] = data.bytes.subarray(offset, offset + len);
			     // category.testing[i - threshold].label = label;
			    }
		}
	}
	
	public void trainEpoch() {
		//for (int i = 0; i < training.length; i++) {
		int key =0;
			switch(key) {
			case 0:	double[] data = new double[] {};
					
				    double[][] inputs = Matrix.fromArray(data, mT.data);
				    double[][] divOut = Matrix.divMap(inputs);
				    //let label = training[i].label;
				    double[] tar = new double[]{1, 0};
				    double[][] targets = Matrix.fromArray(tar, mT.data);
				    //nn.train(divOut, targets);
					break;
					
			case 1:	data = new double[] {};
					inputs = Matrix.fromArray(data, mT.data);
					divOut = Matrix.divMap(inputs);
					//let label = training[i].label;
					tar = new double[]{0, 1};
					targets = Matrix.fromArray(tar, mT.data);
					//nn.train(divOut, targets);
					break;
		    
		  }
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		ArrayList<String> imagesOne = new ArrayList();
        ArrayList<String> imagesTwo = new ArrayList();

        int i = 0;
        for (; args[i+2].charAt(0) != '-'; i++)
        	for(int j=0;j<100;j++)
        		imagesOne.add(args[i + 2]+"a ("+j+").bmp");

        i += 2;
        String objOne = args[1];
        String objTwo = args[i++];

        for (; i < args.length-2; i++)
        	for(int j=0;j<100;j++)
        		imagesTwo.add(args[i]+"1 ("+j+").jpg");
        
        String imageThree = args[i];
        String imageFour = args[i++];

        main.feedPicture(objOne, objTwo, imagesOne, imagesTwo, imageThree, imageFour);
		//main.trigger();
		//for(double val:main.output)
		//System.out.println(val);
	}
	
	private void feedPicture(String objOne, String objTwo,ArrayList<String> imagesOne, ArrayList<String> imagesTwo, String imageThree, String imageFour) {
		nn = new NeuralNetwork(NUMBER_OF_INPUTS, 250, 2);
		Random random = new Random();		
		int cat = 0;
		int dog = 0;
		double[] data;
		double[][] inputs;
		double[][] divOut;
		int key =0;
		for(int l=0;l<250;l++)
		{		
			cat = 0;
			dog = 0;
		for(int k=0;k<200;k++)
		{
			key =random.nextInt(2);
			Matrix mIn;
			if(imagesOne.size()<=cat)
				key = 1;
			if(imagesTwo.size()<=dog)
				key = 0;
			if(imagesTwo.size()<=dog && imagesOne.size()<=cat)
				key =2;
			
				switch(key) {
				case 0:	data = openImage(imagesOne.get(cat));
						mIn = new Matrix(data.length,1);
					    inputs = Matrix.fromArray(data, mIn.data);
					    divOut = Matrix.divMap(inputs);
					    //let label = training[i].label;
					    double[] tar = new double[]{1, 0};
					    double[][] targets = Matrix.fromArray(tar, mT.data);
					    nn.train(divOut, targets, cat, "human");
					    cat++;
						break;
						
				case 1:	data =  openImage(imagesTwo.get(dog));
						mIn = new Matrix(data.length,1);
						inputs = Matrix.fromArray(data, mIn.data);
						divOut = Matrix.divMap(inputs);
						//let label = training[i].label;
						tar = new double[]{0, 1};
						targets = Matrix.fromArray(tar, mT.data);
						nn.train(divOut, targets, dog, "out");
						dog++;
						break;
						
				}
		  }
		}
		data =  openImage(imageThree);
		Matrix mIn = new Matrix(data.length,1);
		inputs = Matrix.fromArray(data, mIn.data);
		divOut = Matrix.divMap(inputs);
		//let label = training[i].label;
		
		double[] out = nn.feedforward(divOut);
		System.out.println(out[0]+","+out[1]); 
		
		data =  openImage(imageFour);
		mIn = new Matrix(data.length,1);
		inputs = Matrix.fromArray(data, mIn.data);
		divOut = Matrix.divMap(inputs);
		//let label = training[i].label;
		
		 out = nn.feedforward(divOut);
		System.out.println(out[0]+","+out[1]); 
    }
	
	private int getBin(int value) {
        int bin = 1;
        if (value < 8)
            bin = 1;
        else if (value < 16)
            bin = 2;
        else if (value < 24)
            bin = 3;
        else if (value < 32)
            bin = 4;
        else if (value < 40)
            bin = 5;
        else if (value < 48)
            bin = 6;
        else if (value < 56)
            bin = 7;
        else if (value < 64)
            bin = 8;
        else if (value < 72)
            bin = 9;
        else if (value < 80)
            bin = 10;
        else if (value < 88)
            bin = 11;
        else if (value < 96)
            bin = 12;
        else if (value < 104)
            bin = 13;
        else if (value < 112)
            bin = 14;
        else if (value < 120)
            bin = 15;
        else if (value < 128)
            bin = 16;
        else if (value < 136)
            bin = 17;
        else if (value < 144)
            bin = 18;
        else if (value < 152)
            bin = 19;
        else if (value < 160)
            bin = 20;
        else if (value < 168)
            bin = 21;
        else if (value < 176)
            bin = 22;
        else if (value < 184)
            bin = 23;
        else if (value < 192)
            bin = 24;
        else if (value < 200)
            bin = 25;
        else if (value < 208)
            bin = 26;
        else if (value < 216)
            bin = 27;
        else if (value <= 225)
            bin = 28;
        return bin;
    }
	
	 /* converts to grayscale lol */
    private void convertToGrayscale(BufferedImage img, int width, int height, int[][] grayImage) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                int avg = (r + g + b) / 3;
                grayImage[x][y] = avg;
            }
        }
    }
    
    /* normalizes the pic to make it suitable for passing to the perceptron */
    private void normalize(int width, int height, int[][] grayImg, double[] normalized) {
        int[] bins = new int[NUMBER_OF_INPUTS];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (0 != getBin(grayImg[x][y])) {
                    int bin = getBin(grayImg[x][y]);
                    bins[bin-1] += 1;
                }
            }
        }

        double all = 0;
        for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
            all += bins[i];
        }

        for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
            normalized[i] = bins[i] / all;
        }
    }
    
    /* opens an image with passed path and returns a normalized array of that image */
    private double[] openImage(String image_path) {
        try {
            //System.out.println(image_path);
            BufferedImage img = ImageIO.read(new File(image_path));
            int width = img.getWidth();
            int height = img.getHeight();
            int[][] grayImg = new int[width][height];
            convertToGrayscale(img, width, height, grayImg);
            double[] normalized = new double[NUMBER_OF_INPUTS];
            normalize(width, height, grayImg, normalized);
            return normalized;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
