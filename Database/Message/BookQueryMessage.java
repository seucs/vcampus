package Message;

import java.io.Serializable;

public class BookQueryMessage implements Serializable {
	private String content;
	private boolean authorornot;
	private boolean novel ;
	private boolean essay ;
	private boolean poetry ;
	private boolean finance ;
	private boolean computer ;
	private boolean electron ;
	private boolean physics ;
	private boolean maths ;
	private boolean chemisty ;
	private boolean biology ;
	private boolean lanuage ;
	
	
	public BookQueryMessage(String content, boolean authorornot, boolean novel, boolean essay, boolean poetry,
			boolean finance, boolean computer, boolean electron, boolean physics, boolean maths, boolean chemisty,
			boolean biology, boolean lanuage) {
		super();
		this.content = content;
		this.authorornot = authorornot;
		this.novel = novel;
		this.essay = essay;
		this.poetry = poetry;
		this.finance = finance;
		this.computer = computer;
		this.electron = electron;
		this.physics = physics;
		this.maths = maths;
		this.chemisty = chemisty;
		this.biology = biology;
		this.lanuage = lanuage;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isAuthor() {
		return authorornot;
	}
	public void setAuthor(boolean author) {
		this.authorornot = author;
	}
	public boolean isNovel() {
		return novel;
	}
	public void setNovel(boolean novel) {
		this.novel = novel;
	}
	public boolean isEssay() {
		return essay;
	}
	public void setEssay(boolean essay) {
		this.essay = essay;
	}
	public boolean isPoetry() {
		return poetry;
	}
	public void setPoetry(boolean poetry) {
		this.poetry = poetry;
	}
	public boolean isFinance() {
		return finance;
	}
	public void setFinance(boolean finance) {
		this.finance = finance;
	}
	public boolean isComputer() {
		return computer;
	}
	public void setComputer(boolean computer) {
		this.computer = computer;
	}
	public boolean isElectron() {
		return electron;
	}
	public void setElectron(boolean electron) {
		this.electron = electron;
	}
	public boolean isPhysics() {
		return physics;
	}
	public void setPhysics(boolean physics) {
		this.physics = physics;
	}
	public boolean isMaths() {
		return maths;
	}
	public void setMaths(boolean maths) {
		this.maths = maths;
	}
	public boolean isChemisty() {
		return chemisty;
	}
	public void setChemisty(boolean chemisty) {
		this.chemisty = chemisty;
	}
	public boolean isBiology() {
		return biology;
	}
	public void setBiology(boolean biology) {
		this.biology = biology;
	}
	public boolean isLanuage() {
		return lanuage;
	}
	public void setLanuage(boolean lanuage) {
		this.lanuage = lanuage;
	}
	
	
}
