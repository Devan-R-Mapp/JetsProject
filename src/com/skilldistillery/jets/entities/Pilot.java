package com.skilldistillery.jets.entities;

public class Pilot {
	private String name;
	private String catchphrase;
	private int skill;
	private int experiance;

	public Pilot() {

	}

	public Pilot(String name, String catchphrase, int skill, int experiance) {
		super();
		this.name = name;
		this.catchphrase = catchphrase;
		this.skill = skill;
		this.experiance = experiance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchphrase() {
		return catchphrase;
	}

	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}

}
