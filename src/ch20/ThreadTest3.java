package ch20;

public class ThreadTest3 {

	public static void main(String[] args) {
		Memory mem = new Memory(16);
		Download down = new Download(mem);
		Play play = new Play(mem);
		down.start();
		play.start();

	}

}

class Memory{
	int[] buffer;
	int size;
	int progress;
	public Memory(int asize) {
		size = asize;
		buffer = new int[asize];
		progress = 0;
	}
	
	synchronized void DownChunk(int off) {
		for (int chunk = 0; chunk < 2; chunk++) {
			buffer[off+chunk] = off+chunk;
			progress = off + chunk + 1;
		}
		try {Thread.sleep(200);}catch(InterruptedException e){;}
	}
	
	synchronized void PlayDownload() {
		for (int off = 0; off < progress; off++) {
			System.out.print(buffer[off] + " ");
		}
		System.out.println();
	}
}

class Download extends Thread{
	Memory mem;
	public Download(Memory amem) {
		mem = amem;
	}
	
	public void run() {
		for(int off = 0; off < mem.size; off += 2) {
			mem.DownChunk(off);
		}
	}
}

class Play extends Thread{
	Memory mem;
	Play(Memory amem){
		mem = amem;
	}
	
	public void run() {
		for (;;) {
			mem.PlayDownload();
			if(mem.progress == mem.size) break;
			try {Thread.sleep(500);}catch(InterruptedException e){;}
		}
	}
}
