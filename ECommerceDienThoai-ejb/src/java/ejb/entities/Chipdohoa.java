/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DacTien
 */
@Entity
@Table(name = "chip_do_hoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChipDoHoa.findAll", query = "SELECT c FROM ChipDoHoa c")
    , @NamedQuery(name = "ChipDoHoa.findById", query = "SELECT c FROM ChipDoHoa c WHERE c.id = :id")
    , @NamedQuery(name = "ChipDoHoa.findByTenChip", query = "SELECT c FROM ChipDoHoa c WHERE c.tenChip = :tenChip")
    , @NamedQuery(name = "ChipDoHoa.findByAnHien", query = "SELECT c FROM ChipDoHoa c WHERE c.anHien = :anHien")})
public class ChipDoHoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten_chip")
    private String tenChip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "an_hien")
    private boolean anHien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChipDoHoa", fetch = FetchType.LAZY)
    private List<ThongSoKyThuat> thongSoKyThuatList;

    public ChipDoHoa() {
    }

    public ChipDoHoa(Integer id) {
        this.id = id;
    }

    public ChipDoHoa(Integer id, String tenChip, boolean anHien) {
        this.id = id;
        this.tenChip = tenChip;
        this.anHien = anHien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenChip() {
        return tenChip;
    }

    public void setTenChip(String tenChip) {
        this.tenChip = tenChip;
    }

    public boolean getAnHien() {
        return anHien;
    }

    public void setAnHien(boolean anHien) {
        this.anHien = anHien;
    }

    @XmlTransient
    public List<ThongSoKyThuat> getThongSoKyThuatList() {
        return thongSoKyThuatList;
    }

    public void setThongSoKyThuatList(List<ThongSoKyThuat> thongSoKyThuatList) {
        this.thongSoKyThuatList = thongSoKyThuatList;
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
        if (!(object instanceof ChipDoHoa)) {
            return false;
        }
        ChipDoHoa other = (ChipDoHoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.ChipDoHoa[ id=" + id + " ]";
    }
    
}
