package threadsiledeneme;

public class MyThread3 extends Thread implements InterfaceThread
{
    public static int a,b;
    int satir,sutun;
     long baslamaZamani,durmaZamani,gecenZaman;
    public MyThread3(int satir,int sutun)
    {
        super();
        this.satir = satir;
        this.sutun = sutun;
    }
    
    @Override
    public void run()
    {
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         baslamaZamani = System.currentTimeMillis();

        SudokuCoz3 sud = new SudokuCoz3();
        SudokuCoz3.Hucre hucre = new SudokuCoz3.Hucre(satir, sutun);
        boolean cozuldu = SudokuCoz3.coz(hucre);
        
        if (!cozuldu) 
        {
            System.out.println("SUDOKU çözülemedi.");
            return;
        }
        
        System.out.println("ÇÖZÜM\n");
        SudokuCoz3.diziYazdir(SudokuCoz3.dizimiz3);
            durmaZamani = System.currentTimeMillis();
            gecenZaman = durmaZamani - baslamaZamani;
            System.out.println("\n" + gecenZaman + " milisaniye = üçüncü thread"); 
            
            if(thread1.isAlive()==true){
                thread1.stop();
                System.out.println("\nthread1 durdu");
            }
            if(thread2.isAlive()==true){
                thread2.stop();
                System.out.println("\nthread2 durdu");
            }
    }
}
