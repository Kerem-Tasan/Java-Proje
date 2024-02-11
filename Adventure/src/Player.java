import java.util.Scanner;

public class Player {
    public int getHealth;
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private int orjHealth;


    Scanner inp=new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }
    public void selectChar(){

        GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler:");
        System.out.println("------------------------------------------------------------");
        for (GameChar gamechar:charList) {

            System.out.println("\t Karakter: "+gamechar.getName()+
                    " \tHasar: "+gamechar.getDamage()+
                    " \tCan: "+gamechar.getHealth()+
                    " \tPara: "+gamechar.getMoney()+
                    " \tID: "+gamechar.getId());
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Lütfen bir karakter giriniz");

        int selectChar= inp.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        System.out.println(" Karakter: "+this.getCharName()+
                " Hasar: "+this.getDamage()+
                " Can: "+this.getHealth()+
                 " Para: "+this.getMoney());

    }




    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }
    public void printInfo(){
        System.out.println("Silahınız : "+this.getInventory().getWeapon().getName()+
                 ", Zırhınız : "+this.getInventory().getArmor().getName()+
                 ", Bloklama : "+this.getInventory().getArmor().getParry()+
                 ", Hasar : "+ this.getTotalDamage()+
                 ", Sağlık : "+this.getHealth()+
                 ", Para : " +this.getMoney()
        );
    }
public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
}
    public int getDamage() {
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }



    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }
}
