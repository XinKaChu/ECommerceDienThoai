/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import ejb.entities.CtPhieuMuaHang;
import ejb.entities.PhieuMuaHang;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DacTien
 */
@Stateless
@LocalBean
public class CtPhieuMuaHangBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<CtPhieuMuaHang> layChiTietTheoMaPhieuMuaHang(Integer id) {
        Query query = em.createQuery("SELECT n FROM CtPhieuMuaHang n WHERE n.idPhieuMuaHang.id=:e");
        query.setParameter("e", id);
        return query.getResultList();
    }

}
