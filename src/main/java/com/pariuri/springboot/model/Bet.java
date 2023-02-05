package com.pariuri.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "bets")
public class Bet {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "team1")
	private String team1;
	
	@Column(name = "team2")
	private String team2;
	
	@Column(name = "win_1")
	private String win_1;

	@Column(name = "tie_x")
	private String tie_x;

	@Column(name = "win_2")
	private String win_2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getWin_1() {
		return win_1;
	}

	public void setWin_1(String win_1) {
		this.win_1 = win_1;
	}

	public String getTie_x() {
		return tie_x;
	}

	public void setTie_x(String tie_x) {
		this.tie_x = tie_x;
	}

	public String getWin_2() {
		return win_2;
	}

	public void setWin_2(String win_2) {
		this.win_2 = win_2;
	}
}
