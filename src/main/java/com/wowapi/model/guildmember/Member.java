
package com.wowapi.model.guildmember;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Member {

    @Expose
    private Character character;
    @Expose
    private Long rank;

    /**
     * 
     * @return
     *     The character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * 
     * @param character
     *     The character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * 
     * @return
     *     The rank
     */
    public Long getRank() {
        return rank;
    }

    /**
     * 
     * @param rank
     *     The rank
     */
    public void setRank(Long rank) {
        this.rank = rank;
    }

}
