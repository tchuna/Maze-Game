package maze.logic;

public class Hero extends Character{
	
	private Boolean isDead;
	private Boolean win;

	public Hero(int x,int y) {
		super(x,y,'H');
		this.isDead=false;
		this.win=false;
	}
	
	
	
	public Boolean getIsDead(){
		return this.isDead;
	}
	
	public void  setIsDead() {
		this.isDead=true;
	}
	
	public Boolean getWin(){
		return this.win;
	}
	
	public void  setWin() {
		this.win=true;
	}
	
	
	
}
