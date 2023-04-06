package twin.Personality.Traits.Interests;

import javax.persistence.*;

@Entity
@Table(name="interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "interest")
    private String interest;

    @Column(name = "scale")
    private int scale;  //scale from 0-10 of how interesting this topic is

    public Interest(){

    }

    public Interest(String interest, int scale){
        this.interest = interest;
        if(scale <= 0){
            this.scale = 0;
        }
        else if(scale >= 10){
            this.scale = 10;
        }
        else{
            this.scale = scale;
        }
    }

    public long getId() {
        return id;
    }

    public String getInterest(){
        return interest;
    }

    public void setInterest(String interest){
        this.interest = interest;
    }

    public int getScale(){
        return scale;
    }

    public void setScale(int newScale){
        if(newScale >= 0 && newScale <= 10){
            scale = newScale;
        }
        else if(newScale > 10){
            scale = 10;
        }
        else{
            scale = 0;
        }
    }
}

