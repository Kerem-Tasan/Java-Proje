public class Armor {
    private String name;
    private int id;
    private int parry;
    private int price;

    public static Armor[] armors(){
       Armor[] ArmorList=new Armor[3];
        ArmorList[0]=new Armor("Heavy Armor",1,1,15);
       ArmorList[1]= new Armor("Golden Armor",2,3,25);
        ArmorList[2]= new Armor("ShardPlate",3,5,40);
        return ArmorList;

    }
    public static Armor getArmorObjByID(int id){
        for(Armor a:Armor.armors()){
            if(a.getId()==id){
                return a;

            }

        }
        return null;
    }
    public Armor(String name, int id, int parry, int price) {
        this.name = name;
        this.id = id;
        this.parry = parry;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParry() {
        return parry;
    }

    public void setParry(int parry) {
        this.parry = parry;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
