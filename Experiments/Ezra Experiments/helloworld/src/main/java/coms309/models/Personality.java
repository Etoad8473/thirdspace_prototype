package coms309.models;

public class Personality
{

    private int personalityType;
    Personality(int type)
    {
        personalityType = type;
    }

    Personality()
    {
        personalityType = 1;
    }

    public int getPersonalityType() {
        return personalityType;
    }

    public void setPersonalityType(int personalityType) {
        this.personalityType = personalityType;
    }

    @Override public String toString(){return "this is a personality";}

}
