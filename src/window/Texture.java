package window;

import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class Texture {
	
	

	SpriteSheet bs, ps,groundS,treeS,gemS;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage ground_sheet = null;
	private BufferedImage tree_sheet = null;
	private BufferedImage gem_sheet=null;
//	public BufferedImage[] block = new BufferedImage[10];
//	public BufferedImage[] player = new BufferedImage[14];
//	public BufferedImage[] player_jump = new BufferedImage[6];
	
	
	//player movement image array//////////////////////////////////////////
	public ArrayList<BufferedImage> playerA= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> playerD= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> playerW= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> playerS= new ArrayList<BufferedImage>();
	////////////////////////////////////////////////////////////////////////
	public ArrayList<BufferedImage> ground= new ArrayList<BufferedImage>();
	////////////////////////////////////////////////////////////////////////
	private ArrayList<BufferedImage> player_jump= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> block= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> tree= new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> enemy= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> gems=new ArrayList<BufferedImage>();

	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			ground_sheet=loader.loadImage("/ground.png");
			block_sheet = loader.loadImage("/block_sheet.png");
			tree_sheet = loader.loadImage("/block_sheet.png");
			player_sheet=loader.loadImage("/Ranger-M-01.png");
			gem_sheet=loader.loadImage("/gemss.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		groundS=new SpriteSheet(ground_sheet);
		bs = new SpriteSheet(block_sheet);
		treeS= new SpriteSheet(tree_sheet);
		ps = new SpriteSheet(player_sheet);
		gemS= new SpriteSheet(gem_sheet);
		getTextures();
	}

	private void getTextures() {
//		block[0] = bs.grabImage(1, 1, 32, 32);// dirt block
//		block[1] = bs.grabImage(2, 1, 32, 32);// grass block
//
//		// walking animation right
//
//		for (int i = 0; i < 7; i++) {
//			player[i] = ps.grabImage(i+1, 1, 32, 64);
//		}
		

		
//		
//		// walking animation left
//		for (int i = 7; i < 14; i++) {
//		
//			player[i] = ps.grabImage(i+7, 1, 32, 64);
//		}
//		
//		// jump animation 
//		for (int i = 0; i < 6; i++) {
//			player_jump[i] = ps.grabImage(i+7, 2, 32, 64);
//		}
//		
//		for(int i=0; i<6; i++) {
//			player.add(ps.grabImage(i+7, 2, 32, 32));
//		}
		
		///////player movement//////////////
			for(int i=0; i<3; i++) {
				playerW.add(ps.grabImage(i+1, 1, 24, 32));
			}
			
			for(int i=0; i<3; i++) {
				playerD.add(ps.grabImage(i+1, 2, 24, 32));
			}
			for(int i=0; i<3; i++) {
				playerS.add(ps.grabImage(i+1, 3, 24, 32));
			}
			for(int i=0; i<3; i++) {
				playerA.add(ps.grabImage(i+1, 4, 24, 32));
			}
		//////////////////////////////////////////	
			
			
			tree.add(treeS.grabImage(2, 4, 32, 32));
			
		
			block.add(bs.grabImage(1, 1, 32, 32));
			block.add(bs.grabImage(2, 1, 32, 32));

		
	
			ground.add(groundS.grabImage(1, 1, 32, 32));
			ground.add(groundS.grabImage(2, 1, 32, 32));
			ground.add(groundS.grabImage(6, 1, 32, 32));
			ground.add(groundS.grabImage(1, 2, 32, 32));
		
			gems.add(gemS.grabImage(1, 2, 32, 32));
		// player[1]=ps.grabImage(2, 1, 32, 64);
		// player[2]=ps.grabImage(3, 1, 32, 64);
		// player[3]=ps.grabImage(4, 1, 32, 64);
		// player[4]=ps.grabImage(5, 1, 32, 64);
		// player[5]=ps.grabImage(6, 1, 32, 64);
		// player[6]=ps.grabImage(7, 1, 32, 64);

	}

}
