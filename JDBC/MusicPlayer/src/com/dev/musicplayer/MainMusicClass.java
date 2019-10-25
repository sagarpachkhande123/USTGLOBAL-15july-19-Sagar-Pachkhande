package com.dev.musicplayer;

import java.util.Scanner;

public class MainMusicClass {

	public static void main(String[] args) {
		MusicIntImplement mi = new MusicIntImplement();
		Scanner sc = new Scanner(System.in);

		while (true) {

			int ch = 0;
			System.out.println("*******************MUSIC PLAYER*******************");
			System.out.println("Please enter your choice");
			System.out.println("\n1.Play a song\n2.Search a song\n3.Show All Song\n4.Operate on Songs");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				int op = 0;
				while (op <= 3) {
					System.out.println("select option");
					System.out.println("1.play All Songs");
					System.out.println("2.play randomly Songs");
					System.out.println("3.play particular Song");
					op = sc.nextInt();
					switch (op) {
					case 1:
						mi.playAllSong();
						break;
					case 2:
						mi.playRandomSong();
						break;
					case 3:
						mi.playParticularSong();
						break;

					default:
						System.out.println("invalid option");
						break;
					}
				}
				break;

			case 2:
				mi.searchSong();
				break;

			case 3:
				mi.showAllSong();
				break;

			case 4:
				int ch1 = 0;
				while (ch1 <= 3) {
					System.out.println("select option");
					System.out.println("1.Add Song");
					System.out.println("2.Edit song");
					System.out.println("3.Delete Song");
					ch1 = sc.nextInt();
					switch (ch1) {
					case 1:
						mi.addSong();
						break;
					case 2:
						mi.editSong();
						break;
					case 3:
						mi.deleteSong();
						break;
					default:
						System.out.println("invalid option");
						break;
					}
				}
				break;

			default:
				System.out.println("invalid option");

			}

		}
	}
}