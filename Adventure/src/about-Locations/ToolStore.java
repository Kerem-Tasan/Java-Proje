public class ToolStore  extends NormalLoc{
    public ToolStore(Player player) {
        super(player,"Mağaza");
    }
    @Override
    boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Mağazaya Hoşgeldiniz");
            System.out.println("1-)Silahlar");
            System.out.println("2-)Zırhlar");
            System.out.println("3-)Çıkış Yap");

            System.out.print("Bölge Seçin:");

            int selectCase = Location.inp.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz değer.Tekrar girin:");
                selectCase = inp.nextInt();

            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("BYEBYE");
                    showMenu = false;
                    break;

                default:

                    break;
            }
        }
        return true;
    }
    public void printWeapon(){

        System.out.println("-----------Silahlar-----------");
        System.out.println("Mevcut paranız:"+this.getPlayer().getMoney());
        System.out.println();
        for (Weapon w:Weapon.weapons()) {
            System.out.println(w.getId()+"-)"+w.getName()+"< Para:"+w.getPrice()+" Hasar:"+w.getDamage()+" >");
        }
        System.out.println("0-) Çıkış");

    }
    public void buyWeapon(){
        System.out.print("Silahını Seç:");

        int selectWeaponID=inp.nextInt();
        while (selectWeaponID<0 || selectWeaponID>Weapon.weapons().length) {
            System.out.print("Geçersiz değer.Tekrar girin:");
            selectWeaponID = inp.nextInt();
        }
        if(selectWeaponID!=0){
            Weapon selectedWeapon=Weapon.getWeaponObjByID(selectWeaponID);
            if(selectedWeapon!=null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli Paranız bulunmamaktadır!");
                }
                else{
                    // Satın alma bölümü
                    System.out.println(selectedWeapon.getName()+" satın aldınız!");
                    int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: "+this.getPlayer().getMoney());

                    System.out.println("Önceki silahınız:"+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız:"+this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }

    public void printArmor(){

        System.out.println("-----------Zırhlar-----------");
        System.out.println();
        for (Armor a:Armor.armors()) {
            System.out.println(a.getId()+"-)"+a.getName()+"< Para:"+a.getPrice()+" Dayanıklılık:"+a.getParry()+" >");
        }
        System.out.println("0-) Çıkış");

    }

    public void buyArmor(){
        System.out.print("Zırhını seç" +
                " Seç:");
        int selectedArmorID=Location.inp.nextInt();
        while (selectedArmorID<0 || selectedArmorID>Armor.armors().length) {
            System.out.print("Geçersiz değer.Tekrar girin:");
            selectedArmorID = inp.nextInt();

        }
        if(selectedArmorID!=0){
            Armor selectedArmor=Armor.getArmorObjByID(selectedArmorID);
            if(selectedArmor!=null){
                if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli Paranız bulunmamaktadır!");
                }
                else{
                    // Satın alma bölümü
                    System.out.println(selectedArmor.getName()+" satın aldınız!");

                    this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                    System.out.println("Kalan paranız: "+this.getPlayer().getMoney());

                    System.out.println("Önceki silahınız:"+this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Silahınız:"+this.getPlayer().getInventory().getArmor().getName());
                    System.out.println("Kalan bakiye:"+ getPlayer().getMoney());



                }
            }
        }
        }



}
