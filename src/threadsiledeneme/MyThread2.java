package threadsiledeneme;

public class MyThread2 extends Thread implements InterfaceThread
{
    public static int a,b;
    int satir,sutun;
    public long baslamaZamani,durmaZamani,gecenZaman;
    public MyThread2(int satir,int sutun)
    {
        super();
        this.satir = satir;
        this.sutun = sutun;
    }
    
    @Override
    public void run()
    {
    	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         baslamaZamani = System.currentTimeMillis();

        SudokuCoz2 sud = new SudokuCoz2();
        SudokuCoz2.Hucre hucre = new SudokuCoz2.Hucre(satir, sutun);
        boolean cozuldu = SudokuCoz2.coz(hucre);
        
        if (!cozuldu) 
        {
            System.out.println("SUDOKU çözülemedi.");
            return;
        }
        
        System.out.println("ÇÖZÜM\n");
        SudokuCoz2.diziYazdir(SudokuCoz2.dizimiz2);
         durmaZamani = System.currentTimeMillis();
          gecenZaman = durmaZamani - baslamaZamani;
       System.out.println("\n" + gecenZaman + " milisaniye = ikinci thread");
       
       if(thread3.isAlive()==true){
                thread3.stop();
                System.out.println("\nthread3 durdu");
            }
            if(thread1.isAlive()==true){
                thread1.stop();
                System.out.println("\nthread1 durdu");
            }
    } 
}
