import java.util.Scanner;

public class Game {
    Scanner inp=new Scanner(System.in);



    public void start() {
        System.out.println("Hoşgeldin! "+
               "\n"+
                "Savaşmaya hazır mısın?");
        System.out.println();
        System.out.print("Savaşçı adın:");
    String playerName=inp.nextLine();
       System.out.println("Hoşgeldin "+playerName);
        Player gamer=new Player("playerName");
       System.out.println(gamer.getName()+" savaş için hazır!");

       System.out.println(playerName+" seni görevde başarıya götürecek karakteri seç!");

        gamer.selectChar();
        Location location=null;
 while(true){
    gamer.printInfo();
    System.out.println();
    System.out.println("Bölgeler:");
    System.out.println("1-) Güvenli Ev-->Canınız dolar!");
    System.out.println("2-) Demirci->>Eşya Satın alabilirsiniz.");
     System.out.println("3-)Mağara-->Mağaraya gir!<Ödül:Yemek> Zombilere karşı dikkatli ol!");
     System.out.println("4-)Orman->>Ormana giriş yap!<Ödül:Odun> Vampirler seni bekliyor! ");
     System.out.println("5-)Nehir->>Nehire giriş yap!<Ödül:Su> Dikkat ayı çıkabilir!");
    System.out.println("0-)Çıkış yap-->Oyunu sonlandırır");
    System.out.print("Gitmek istediğiniz yeri seçin:");
    int selectLocation=inp.nextInt();
    switch(selectLocation){
        case 0 :
            location=null;
break;
        case 1:
            location=new SafeHouse(gamer);

            break;
        case 2:

            location=new ToolStore(gamer);
            break;
        case 3:

            location=new Cave(gamer);

            break;
        case 4:

            location=new Forest(gamer);

            break;
        case 5:

            location=new River(gamer);

            break;
        default:
            System.out.println("Lütfen geçerli bir bölge giriniz!");

            break;
    }
    if(location==null){
        System.out.println("Oyun bitti.Yine bekleriz");
        break;
    }
    if(!location.onLocation()){
        System.out.println(" GAME OVER ");
        break;
    }
}








}
}
