package Interface;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import DAO.Rendez_VousDAO;
import Model.Methode;
import Model.Rendez_Vous;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class PanelPlanning extends JPanel implements ActionListener {

	private HashMap<Date, Date[]> neinCurrentWeek;
	private Date[] currentWeek;
	private Date[] neinCurrentMonday;
	private Date selectedWeekMonday;
	private JPanel panel_Lundi_event;
	private JPanel panel_Mardi_event;
	private JPanel panel_Mercredi_event;
	private JPanel panel_Jeudi_event;
	private JPanel panel_Vendredi_event;
	private JPanel panel_Samedi_event;
	private JLabel lblLundi;
	private JLabel lblMardi;
	private JLabel lblMercredi;
	private JLabel lblJeudi;
	private JLabel lblVendredi;
	private JLabel lblSamedi;
	private Rendez_VousDAO rdvDAO;
	private ArrayList<JButton> btnLunEvent;
	private ArrayList<JButton> btnMarEvent;
	private ArrayList<JButton> btnMerEvent;
	private ArrayList<JButton> btnJeuEvent;
	private ArrayList<JButton> btnVenEvent;
	private ArrayList<JButton> btnSamEvent;
	private ArrayList<ArrayList<JButton>> listPanelEvent;
	private JButton btnWeek1;
	private JButton btnWeek2;
	private JButton btnWeek3;
	private JButton btnWeek4;
	private JButton btnWeek5;
	private JButton btnWeek6;
	private JButton btnWeek7;
	private JButton btnWeek8;
	private JButton btnWeek9;
	private JButton[] btn9Week;
	private JButton btnPreviousWeek;
	private JButton btnNextWeek;

	/**
	 * Create the panel.
	 */
	public PanelPlanning() {
		neinCurrentWeek = Methode.findCurrentWeekInit(new GregorianCalendar(Locale.FRANCE));
		Set<Date> nCWKeySet = neinCurrentWeek.keySet();
		neinCurrentMonday = nCWKeySet.toArray(new Date[nCWKeySet.size()]);
		Arrays.sort(neinCurrentMonday);
		this.selectedWeekMonday = neinCurrentMonday[0];

		rdvDAO = new Rendez_VousDAO();
		listPanelEvent = new ArrayList<>();
		listPanelEvent.add(this.btnLunEvent);
		listPanelEvent.add(this.btnMarEvent);
		listPanelEvent.add(this.btnMerEvent);
		listPanelEvent.add(this.btnJeuEvent);
		listPanelEvent.add(this.btnVenEvent);
		listPanelEvent.add(this.btnSamEvent);
		btn9Week = new JButton[9];

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(30, 10));
		add(panel, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 30));
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 11, 0, 0));

		btnPreviousWeek = new JButton("<");
		btnPreviousWeek.setPreferredSize(new Dimension(30, 23));
		panel_2.add(btnPreviousWeek);

		btnWeek1 = new JButton(Methode.toString(neinCurrentMonday[0]));
		btnWeek1.setBackground(Color.GREEN);
		this.btn9Week[0] = (JButton) btnWeek1;
		panel_2.add(btnWeek1);

		btnWeek2 = new JButton(Methode.toString(neinCurrentMonday[1]));
		this.btn9Week[1] = (JButton) btnWeek2;
		panel_2.add(btnWeek2);

		btnWeek3 = new JButton(Methode.toString(neinCurrentMonday[2]));
		this.btn9Week[2] = (JButton) btnWeek3;
		panel_2.add(btnWeek3);

		btnWeek4 = new JButton(Methode.toString(neinCurrentMonday[3]));
		this.btn9Week[3] = (JButton) btnWeek4;
		panel_2.add(btnWeek4);

		btnWeek5 = new JButton(Methode.toString(neinCurrentMonday[4]));
		this.btn9Week[4] = (JButton) btnWeek5;
		panel_2.add(btnWeek5);

		btnWeek6 = new JButton(Methode.toString(neinCurrentMonday[5]));
		this.btn9Week[5] = (JButton) btnWeek6;
		panel_2.add(btnWeek6);

		btnWeek7 = new JButton(Methode.toString(neinCurrentMonday[6]));
		this.btn9Week[6] = (JButton) btnWeek7;
		panel_2.add(btnWeek7);

		btnWeek8 = new JButton(Methode.toString(neinCurrentMonday[7]));
		this.btn9Week[7] = (JButton) btnWeek8;
		panel_2.add(btnWeek8);

		btnWeek9 = new JButton(Methode.toString(neinCurrentMonday[8]));
		this.btn9Week[8] = (JButton) btnWeek9;
		panel_2.add(btnWeek9);

		btnNextWeek = new JButton(">");
		panel_2.add(btnNextWeek);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 6, 0, 0));

		JPanel panel_Lundi = new JPanel();
		panel_3.add(panel_Lundi);
		panel_Lundi.setLayout(new BorderLayout(0, 0));

		lblLundi = new JLabel("Lundi ");
		lblLundi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Lundi.add(lblLundi, BorderLayout.NORTH);

		panel_Lundi_event = new JPanel();
		panel_Lundi.add(panel_Lundi_event, BorderLayout.CENTER);

		JPanel panel_Mardi = new JPanel();
		panel_3.add(panel_Mardi);
		panel_Mardi.setLayout(new BorderLayout(0, 0));

		lblMardi = new JLabel("Mardi");
		lblMardi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mardi.add(lblMardi, BorderLayout.NORTH);

		panel_Mardi_event = new JPanel();
		panel_Mardi.add(panel_Mardi_event, BorderLayout.CENTER);

		JPanel panel_Mercredi = new JPanel();
		panel_3.add(panel_Mercredi);
		panel_Mercredi.setLayout(new BorderLayout(0, 0));

		lblMercredi = new JLabel("Mercredi");
		lblMercredi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mercredi.add(lblMercredi, BorderLayout.NORTH);

		panel_Mercredi_event = new JPanel();
		panel_Mercredi.add(panel_Mercredi_event, BorderLayout.CENTER);

		JPanel panel_Jeudi = new JPanel();
		panel_3.add(panel_Jeudi);
		panel_Jeudi.setLayout(new BorderLayout(0, 0));

		lblJeudi = new JLabel("Jeudi");
		lblJeudi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Jeudi.add(lblJeudi, BorderLayout.NORTH);

		panel_Jeudi_event = new JPanel();
		panel_Jeudi.add(panel_Jeudi_event, BorderLayout.CENTER);

		JPanel panel_Vendredi = new JPanel();
		panel_3.add(panel_Vendredi);
		panel_Vendredi.setLayout(new BorderLayout(0, 0));

		lblVendredi = new JLabel("Vendredi");
		lblVendredi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Vendredi.add(lblVendredi, BorderLayout.NORTH);

		panel_Vendredi_event = new JPanel();
		panel_Vendredi.add(panel_Vendredi_event, BorderLayout.CENTER);

		JPanel panel_Samedi = new JPanel();
		panel_3.add(panel_Samedi);
		panel_Samedi.setLayout(new BorderLayout(0, 0));

		lblSamedi = new JLabel("Samedi");
		lblSamedi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Samedi.add(lblSamedi, BorderLayout.NORTH);

		panel_Samedi_event = new JPanel();
		panel_Samedi.add(panel_Samedi_event, BorderLayout.CENTER);

		remplissageEvent(this.neinCurrentWeek.get(this.selectedWeekMonday));

	}

	private void remplissageEvent(Date[] currentWeek) {
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				// lundi
				this.lblLundi.setText("Lundi " + Methode.toStringDate(currentWeek[0]));
				btnLunEvent = Methode.createButton(rdvDAO.getRdvInDate(currentWeek[i]).length, "");
				int j = 0;
				for (Rendez_Vous r : rdvDAO.getRdvInDate(currentWeek[i])) {
					btnLunEvent.get(j).setText(r.toString());
					this.panel_Lundi_event.add(btnLunEvent.get(j));
					j++;
				}
				break;
			case 1:
				// mardi
				this.lblMardi.setText("Mardi " + Methode.toStringDate(currentWeek[1]));
				btnMarEvent = Methode.createButton(rdvDAO.getRdvInDate(currentWeek[i]).length, "");
				j = 0;
				for (Rendez_Vous r : rdvDAO.getRdvInDate(currentWeek[i])) {
					btnLunEvent.get(j).setText(r.toString());
					this.panel_Mardi_event.add(btnMarEvent.get(j));
					j++;
				}
				break;
			case 2:
				// mercredi
				this.lblMercredi.setText("Mercredi " + Methode.toStringDate(currentWeek[2]));
				btnMarEvent = Methode.createButton(rdvDAO.getRdvInDate(currentWeek[i]).length, "");
				j = 0;
				for (Rendez_Vous r : rdvDAO.getRdvInDate(currentWeek[i])) {
					btnMarEvent.get(j).setText(r.toString());
					this.panel_Mardi_event.add(btnMarEvent.get(j));
					j++;
				}
				break;
			case 3:
				// jeudi
				this.lblJeudi.setText("Jeudi " + Methode.toStringDate(currentWeek[3]));
				btnJeuEvent = Methode.createButton(rdvDAO.getRdvInDate(currentWeek[i]).length, "");
				j = 0;
				for (Rendez_Vous r : rdvDAO.getRdvInDate(currentWeek[i])) {
					btnJeuEvent.get(j).setText(r.toString());
					this.panel_Jeudi_event.add(btnJeuEvent.get(j));
					j++;
				}
				break;
			case 4:
				// vendredi
				this.lblVendredi.setText("Vendredi " + Methode.toStringDate(currentWeek[4]));
				btnVenEvent = Methode.createButton(rdvDAO.getRdvInDate(currentWeek[i]).length, "");
				j = 0;
				for (Rendez_Vous r : rdvDAO.getRdvInDate(currentWeek[i])) {
					btnVenEvent.get(j).setText(r.toString());
					this.panel_Vendredi_event.add(btnVenEvent.get(j));
					j++;
				}
				break;
			default:
				// samedi
				this.lblSamedi.setText("Samedi " + Methode.toStringDate(currentWeek[5]));
				btnSamEvent = Methode.createButton(rdvDAO.getRdvInDate(currentWeek[i]).length, "");
				j = 0;
				for (Rendez_Vous r : rdvDAO.getRdvInDate(currentWeek[i])) {
					btnSamEvent.get(j).setText(r.toString());
					this.panel_Samedi_event.add(btnSamEvent.get(j));
					j++;
				}
			}
		}
		for (ArrayList<JButton> a : this.listPanelEvent) {
			for (JButton e : a) {
				e.addActionListener(this);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.btnPreviousWeek) {
			GregorianCalendar gC = new GregorianCalendar();
			gC.setTime(this.neinCurrentMonday[0]);
			gC.add(Calendar.DATE, -7);
			neinCurrentWeek = Methode.findCurrentWeekInit(gC);
			Set<Date> nCWKeySet = neinCurrentWeek.keySet();
			neinCurrentMonday = nCWKeySet.toArray(new Date[nCWKeySet.size()]);
			Arrays.sort(neinCurrentMonday);
			setBtnWeek();			
		} else if (arg0.getSource() == this.btnNextWeek) {
			GregorianCalendar gC = new GregorianCalendar();
			gC.setTime(this.neinCurrentMonday[1]);
			neinCurrentWeek = Methode.findCurrentWeekInit(gC);
			Set<Date> nCWKeySet = neinCurrentWeek.keySet();
			neinCurrentMonday = nCWKeySet.toArray(new Date[nCWKeySet.size()]);
			Arrays.sort(neinCurrentMonday);
			setBtnWeek();
		} else {
			// changement de semaine
			for (int i = 0; i < this.btn9Week.length; i++) {
				if (arg0.getSource() == this.btn9Week[i]) {
					this.selectedWeekMonday = this.neinCurrentMonday[i];
					for (int j = 0; j < this.btn9Week.length; i++) {
						this.btn9Week[j].setBackground(null);
					}
					this.btn9Week[i].setBackground(Color.GREEN);
					remplissageEvent(this.neinCurrentWeek.get(this.selectedWeekMonday));
				}
			}
			// viewMore sur un rendez-vous
			for (ArrayList<JButton> a : this.listPanelEvent) {
				if (a.contains(arg0.getSource())) {
					lauchViewMore(a.get(a.indexOf(arg0.getSource())).getText().split("<br>")[0].split(":")[1]);
				}
			}
		}
	}

	private void setBtnWeek() {
		this.btnWeek1.setText(Methode.toString(neinCurrentMonday[0]));
		this.btnWeek2.setText(Methode.toString(neinCurrentMonday[1]));
		this.btnWeek3.setText(Methode.toString(neinCurrentMonday[2]));
		this.btnWeek4.setText(Methode.toString(neinCurrentMonday[3]));
		this.btnWeek5.setText(Methode.toString(neinCurrentMonday[4]));
		this.btnWeek6.setText(Methode.toString(neinCurrentMonday[5]));
		this.btnWeek7.setText(Methode.toString(neinCurrentMonday[6]));
		this.btnWeek8.setText(Methode.toString(neinCurrentMonday[7]));
		this.btnWeek9.setText(Methode.toString(neinCurrentMonday[8]));
	}
	

	private void lauchViewMore(String string) {
		int id_rdv = Integer.parseInt(string);
		JOptionPane.showMessageDialog(this, rdvDAO.find(id_rdv).fullToSting(), "Information du le rendez-vous !", 0,
				new ImageIcon("images/icon-832005_960_720.png"));

	}

}
