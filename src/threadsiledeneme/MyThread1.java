package threadsiledeneme;

public class MyThread1 extends Thread implements InterfaceThread       
{
    public static int a,b;
    int satir,sutun;
    public long baslamaZamani,durmaZamani,gecenZaman;
    public MyThread1(int satir,int sutun)
    {
        super();
        this.satir = satir;
        this.sutun = sutun;
    }
    
    @Override
    public void run()
    {
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       baslamaZamani = System.currentTimeMillis();
        SudokuCoz1 sud = new SudokuCoz1();
        SudokuCoz1.Hucre hucre = new SudokuCoz1.Hucre(satir, sutun);
        boolean cozuldu = SudokuCoz1.coz(hucre);
        
        if (!cozuldu) 
        {
            System.out.println("SUDOKU çözülemedi.");
            
            return;
        }
        
        System.out.println("ÇÖZÜM\n");
        SudokuCoz1.diziYazdir(SudokuCoz1.dizimiz1);
        durmaZamani = System.currentTimeMillis();
         gecenZaman = durmaZamani - baslamaZamani;
       System.out.println("\n" + gecenZaman + " milisaniye = ilk thread");
       
            if(thread3.isAlive()==true){
                thread3.stop();
                System.out.println("\nthread3 durdu");
            }
            if(thread2.isAlive()==true){
                thread2.stop();
                System.out.println("\nthread2 durdu");
            }
    }   
}
