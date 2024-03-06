package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Evenement;
public class EvenementDaoImpl implements IEvenementDao {
@Override
public Evenement save(Evenement p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("INSERT INTO evenement(NOM_EVENEMENT ,DATE_EVENEMENT) VALUES(?,?)");
ps.setString(1, p.getNomEvenement());
ps.setString(2, p.getDateEvenement());
ps.executeUpdate();
PreparedStatement ps2= conn.prepareStatement("SELECT MAX(ID_EVENEMENT) as MAX_ID FROM evenement");
ResultSet rs =ps2.executeQuery();
if (rs.next()) {
p.setIdEvenement(rs.getLong("MAX_ID"));
}
ps.close();
ps2.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public List<Evenement> EvenementParMC(String mc) {
 List<Evenement> prods= new ArrayList<Evenement>();
 Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("select * from evenement where NOM_EVENEMENT LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Evenement p = new Evenement();
p.setIdEvenement(rs.getLong("ID_EVENEMENT"));
p.setNomEvenement(rs.getString("NOM_EVENEMENT"));
p.setDateEvenement(rs.getString("DATE_EVENEMENT"));
prods.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}
@Override
public Evenement getEvenement(Long id) {
 
 Connection conn=SingletonConnection.getConnection();
 Evenement e = new Evenement();
 try {
PreparedStatement ps= conn.prepareStatement("select * from evenement where ID_EVENEMENT = ?");
ps.setLong(1, id);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
e.setIdEvenement(rs.getLong("ID_EVENEMENT"));
e.setNomEvenement(rs.getString("NOM_EVENEMENT"));
e.setDateEvenement(rs.getString("DATE_EVENEMENT"));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return e;
}
@Override
public Evenement updateEvenement(Evenement p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("UPDATE evenement SET NOM_EVENEMENT =?,DATE_EVENEMENT=? WHERE ID_EVENEMENT=?");
ps.setString(1, p.getNomEvenement());
ps.setString(2, p.getDateEvenement());
ps.setLong(3, p.getIdEvenement());
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public void deleteEvenement(Long id) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("DELETE FROM evenement WHERE ID_EVENEMENT = ?");
ps.setLong(1, id);
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
}

}
