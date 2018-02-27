package maze.logic;

public class Hero extends Character{
	
	private Boolean isDead;

	public Hero(int x,int y) {
		super(x,y,'H');
		this.isDead=false;
	}
	
	
	
	public Boolean getIsDead(){
		return this.isDead;
	}
	
	public void  setIsDead() {
		this.isDead=true;
	}
	
	
	
}
