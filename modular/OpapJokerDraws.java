/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modular;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giorg
 */
@Entity
@Table(name = "OPAP_JOKER_DRAWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpapJokerDraws.findAll", query = "SELECT o FROM OpapJokerDraws o")
    , @NamedQuery(name = "OpapJokerDraws.findById", query = "SELECT o FROM OpapJokerDraws o WHERE o.id = :id")
    , @NamedQuery(name = "OpapJokerDraws.findByGameid", query = "SELECT o FROM OpapJokerDraws o WHERE o.gameid = :gameid")
    , @NamedQuery(name = "OpapJokerDraws.findByDrawid", query = "SELECT o FROM OpapJokerDraws o WHERE o.drawid = :drawid")
    , @NamedQuery(name = "OpapJokerDraws.findByDrawtime", query = "SELECT o FROM OpapJokerDraws o WHERE o.drawtime = :drawtime")
    , @NamedQuery(name = "OpapJokerDraws.findByWinnningnumbers", query = "SELECT o FROM OpapJokerDraws o WHERE o.winnningnumbers = :winnningnumbers")
    , @NamedQuery(name = "OpapJokerDraws.findByBonusnumber", query = "SELECT o FROM OpapJokerDraws o WHERE o.bonusnumber = :bonusnumber")
    , @NamedQuery(name = "OpapJokerDraws.findByCountwinners", query = "SELECT o FROM OpapJokerDraws o WHERE o.countwinners = :countwinners")
    , @NamedQuery(name = "OpapJokerDraws.findByDivident", query = "SELECT o FROM OpapJokerDraws o WHERE o.divident = :divident")
    , @NamedQuery(name = "OpapJokerDraws.findByDistributed", query = "SELECT o FROM OpapJokerDraws o WHERE o.distributed = :distributed")
    , @NamedQuery(name = "OpapJokerDraws.findByJackpot", query = "SELECT o FROM OpapJokerDraws o WHERE o.jackpot = :jackpot")})
   // , @NamedQuery(name = "OpapJokerDraws.findByDrawtimeDateRange", query = "SELECT o FROM OpapJokerDraws d WHERE d.drawtime >= :start AND d.drawtime <= :end")})

public class OpapJokerDraws implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "GAMEID")
    private int gameid;
    @Basic(optional = false)
    @Column(name = "DRAWID")
    private int drawid;
    @Basic(optional = false)
    @Column(name = "DRAWTIME")
    @Temporal(TemporalType.DATE)
    private Date drawtime;
    @Basic(optional = false)
    @Column(name = "WINNNINGNUMBERS")
    private String winnningnumbers;
    @Basic(optional = false)
    @Column(name = "BONUSNUMBER")
    private int bonusnumber;
    @Basic(optional = false)
    @Column(name = "COUNTWINNERS")
    private String countwinners;
    @Basic(optional = false)
    @Column(name = "DIVIDENT")
    private String divident;
    @Basic(optional = false)
    @Column(name = "DISTRIBUTED")
    private String distributed;
    @Basic(optional = false)
    @Column(name = "JACKPOT")
    private String jackpot;
  
    public OpapJokerDraws() {
    }

    public OpapJokerDraws(Integer id) {
        this.id = id;
    }

    public OpapJokerDraws(Integer id, int gameid, int drawid, Date drawtime, String winnningnumbers, int bonusnumber, String countwinners, String divident, String distributed, String jackpot) {
        this.id = id;
        this.gameid = gameid;
        this.drawid = drawid;
        this.drawtime = drawtime;
        this.winnningnumbers = winnningnumbers;
        this.bonusnumber = bonusnumber;
        this.countwinners = countwinners;
        this.divident = divident;
        this.distributed = distributed;
        this.jackpot = jackpot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getDrawid() {
        return drawid;
    }

    public void setDrawid(int drawid) {
        this.drawid = drawid;
    }

    public Date getDrawtime() {
        return drawtime;
    }

    public void setDrawtime(Date drawtime) {
        this.drawtime = drawtime;
    }

    public String getWinnningnumbers() {
        return winnningnumbers;
    }

    public void setWinnningnumbers(String winnningnumbers) {
        this.winnningnumbers = winnningnumbers;
    }

    public int getBonusnumber() {
        return bonusnumber;
    }

    public void setBonusnumber(int bonusnumber) {
        this.bonusnumber = bonusnumber;
    }

    public String getCountwinners() {
        return countwinners;
    }

    public void setCountwinners(String countwinners) {
        this.countwinners = countwinners;
    }

    public String getDivident() {
        return divident;
    }

    public void setDivident(String divident) {
        this.divident = divident;
    }

    public String getDistributed() {
        return distributed;
    }

    public void setDistributed(String distributed) {
        this.distributed = distributed;
    }

    public String getJackpot() {
        return jackpot;
    }

    public void setJackpot(String jackpot) {
        this.jackpot = jackpot;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpapJokerDraws)) {
            return false;
        }
        OpapJokerDraws other = (OpapJokerDraws) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.OpapJokerDraws[ id=" + id + " ]";
    }
    
}
