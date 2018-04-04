package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Materiel;
import Singleton.SingletonConnection;

public class MaterielDAO extends DAO<Materiel>{

	Connection SC = SingletonConnection.getConnection();

	@Override
	public boolean create(Materiel obj) {
		try {

			PreparedStatement prepare = SC
					.prepareStatement("Insert into \"Materiel\"(nom,type,\"numSerie\") values (?,?,?);");

			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getType());
			prepare.setString(3, obj.getNumSerie());
			
			prepare.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Materiel obj) {
		try{
			PreparedStatement prepare =SC.prepareStatement("Delete from \"Materiel\" where id_materiel=?");

			prepare.setInt(1, obj.getId_materiel());
			
			prepare.executeUpdate();
			
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Materiel obj) {
		try{
			PreparedStatement prepare=SC.prepareStatement("Update \"Materiel\" set nom=?, type=?, numSerie=? where id_materiel=?");
			
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getType());
			prepare.setString(3, obj.getNumSerie());
			prepare.setInt(4, obj.getId_materiel());

			prepare.executeUpdate();
			return true;	
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Materiel find(int id) {
		Materiel mat = new Materiel();
		try{
			PreparedStatement prepare = SC.prepareStatement("SELECT * FROM \"Materiel\" WHERE id_materiel=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			prepare.setInt(1, id);
			ResultSet result=prepare.executeQuery();
			
			if(result.first()){
				mat.setId_materiel(id);
				mat.setNom(result.getString("nom"));
				mat.setType(result.getString("type"));
				mat.setNumSerie(result.getString("numSerie"));					
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mat;
	}

}