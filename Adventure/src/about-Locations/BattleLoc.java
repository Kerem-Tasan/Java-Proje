import java.util.Random;

public abstract class BattleLoc extends Location{
private Obstacle obstacle;
private String award;
private int maxObstacle;
    @Override
    boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("######################");
        System.out.println("Şuan buradasınız:"+ this.getName());
        System.out.println("Dikkatli Ol! Burada "+obsNumber+" tane "+ getObstacle().getName()+ " yaşıyor!");
        System.out.print("<S>Savaş "
                            +"<K>Kaç");
        String selectCase=inp.nextLine();
        selectCase=selectCase.toUpperCase();
        if(selectCase.equals("S")&&combat(obsNumber)) {

            System.out.println(this.getObstacle().getName() + " düşmanlarını temizlediniz");
            return true;
        }
          if(this.getPlayer().getHealth()<0){
              System.out.println("Öldünüz!!!");
              return false;
          }


        return true;
    }

 public boolean combat(int obsNumber) {
     for (int i = 1; i <= obsNumber; i++) {
         this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
         playerStats();
         obstacleStats(i);

     while (this.getObstacle().getHealth() > 0 && this.getPlayer().getHealth() > 0) {
         System.out.println("<V>vur veya <K>Kaç : ");
         String selectCombat = inp.nextLine().toUpperCase();
         if (selectCombat.equals("V")) {
             this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
             afterHit();
             if (this.getObstacle().getHealth() > 0) {
                 System.out.println();
                 System.out.println("Hasar yediniz");
                 int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getParry();
                 if (obstacleDamage < 0) {
                     obstacleDamage = 0;
                 }
                 this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getObstacle().getDamage());
                 afterHit();
             }
         } else {
             return false;
         }

     }
     if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
         System.out.println("Düşmanı yendiniz!");
         System.out.println(this.getObstacle().getAward() + " para kazandınız!");
         this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
         System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
     } else {
         return false;


     }


        }
        return true;
 }

 public void afterHit(){
     System.out.println("Canınız : "+ this.getPlayer().getHealth());
     System.out.println(this.getObstacle().getName()+" Sağlığı : "+ this.getObstacle().getHealth());
     System.out.println();



 }
 public void playerStats(){
     System.out.println("Oyuncu Değerleri");
     System.out.println("----------------------");
     System.out.println("Sağlık : "+ this.getPlayer().getHealth());
     System.out.println("Hasar : "+ this.getPlayer().getTotalDamage());
     System.out.println("Para : "+ this.getPlayer().getMoney());
     if(this.getPlayer().getInventory().getWeapon().getDamage()>0){
         System.out.println("Silah : "+this.getPlayer().getWeapon().getName());
     }
     System.out.println("Zırh :" +this.getPlayer().getInventory().getArmor().getName());


 }
 public void obstacleStats(int i ){
     System.out.println(i+"."+this.getObstacle().getName()+" değerleri:");
     System.out.println("-------------------------");
     System.out.println("Sağlık : "+ this.getObstacle().getHealth());
     System.out.println("Hasar : "+ this.getObstacle().getDamage());
     System.out.println("Ödül : "+ this.getObstacle().getAward());


 }

    public int randomObstacleNumber(){
        Random rand=new Random();
        return rand.nextInt(this.getMaxObstacle())+1;
    }

    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }


    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
