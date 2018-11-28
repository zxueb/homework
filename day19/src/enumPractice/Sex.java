package enumPractice;

public enum Sex {
    /**
     * 男性
     */
    MALE("男"),
    /**
     * 女性
     */
    FEMALE("女");
    private String cnName;
    public String cnName(){
        return this.cnName;
    }
    Sex(String cnName){
        this.cnName = cnName;
    }

}
