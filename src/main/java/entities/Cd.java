package entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String Title;

    private String Year;


    private String Price;

    @OneToMany
    @JoinColumn(name = "cd_id")
    public List<Artist> artistList = new ArrayList<Artist>();


    public Cd() {
    }

    public Artist findByArtistList(Integer id){
        for(int i =0; i<artistList.size(); i++){
            if(id == null ? artistList.get(i).getIdArtist() == null : id.equals(artistList.get(i).getIdArtist())){
                return artistList.get(i);
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }


    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

}
