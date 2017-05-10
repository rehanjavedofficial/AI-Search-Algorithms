package com.rehanjaved.cardguess_ai.frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.rehanjaved.cardguess_ai.geneticAlgorithm.Values;
import com.rehanjaved.cardguess_ai.geneticAlgorithm.GeneticAlgorithm;
import com.rehanjaved.cardguess_ai.geneticAlgorithm.Chromosome;
import com.rehanjaved.cardguess_ai.geneticAlgorithm.Population;

/**
 * @author Rehan Javed
 * @company RJ APPS
 * @version 1.0.1
 * @date 10 May 2017
 * 
 * Contains GUI of the card guess
 * game.
 * 
 */
public class CardGuess extends JFrame {

	// Attributes.
	private static final long serialVersionUID = 2382285924372198697L;
	private JPanel contentPane;
	private JLabel[] card;
	private JTextField sum;
	private JTextField product;
	private JLabel sumLabel;
	private JLabel title;
	private JLabel productLabel;
	private JButton cards;
	private JButton findCards;
	private JButton reset;
	private JLabel result;

	/**
	 * Constructor to initialize the form
	 * elements and add them to form.
	 */
	public CardGuess() {

		card = new JLabel[4];
		
		setTitle("Card Guessing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Components..
		Components();
		
	}
	
	/**
	 * Finding the cards.
	 */
	private void findCards(){
		
		try{
			
			Values.TOTAL_SUM = Integer.parseInt(sum.getText());
			Values.TOTAL_PRODUCT = Integer.parseInt(product.getText());
			
			GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
			Population population = new Population(2000);
			int iteartionCounter = 0;
			
			while(population.getHealthyChromosome().getFitness() != Values.MAX_FITNESS_POINTS && iteartionCounter < Values.MAX_ITERATIONS){
				iteartionCounter++;
				population = geneticAlgorithm.updatePopulation(population);
			}	
			
			Chromosome fitest = population.getHealthyChromosome();
			
			if(fitest.getFitness() == Values.MAX_FITNESS_POINTS){
				int[] genes = fitest.getGenes();
				String sumText = "SUM [";
				String multText = "PRODUCT [";
				for(int i = 0; i < genes.length; i++){
					sumText += genes[i];
					multText += genes[i];
					if(i != genes.length - 1){	
						sumText += "+";
						multText += "x";
					}
					card[i].setIcon(new ImageIcon("cards/"+genes[i]+".png"));
				}
				sumText += " = "+Values.TOTAL_SUM+"] & ";
				multText += " = "+Values.TOTAL_PRODUCT+"] (-_-)";
				result.setText("Result  ==>> "+sumText+multText);
				JOptionPane.showMessageDialog(null, "Found.");
			}else
				JOptionPane.showMessageDialog(null, "Try Again, no any valid solution found.");
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Enter valid details..");
		}
		
	}
	
	/**
	 * Initializing the components.
	 */
	private void Components(){
		
		card[0] = new JLabel(new ImageIcon("cards/0.png"));
		card[0].setBounds(28, 119, 103, 150);
		contentPane.add(card[0]);
		
		card[1] = new JLabel(new ImageIcon("cards/0.png"));
		card[1].setBounds(143, 119, 103, 150);
		contentPane.add(card[1]);
		
		card[2] = new JLabel(new ImageIcon("cards/0.png"));
		card[2].setBounds(258, 119, 103, 150);
		contentPane.add(card[2]);
		
		card[3] = new JLabel(new ImageIcon("cards/0.png"));
		card[3].setBounds(373, 119, 103, 150);
		contentPane.add(card[3]);
		
		JLabel lblDevelopedByRehan = new JLabel("Developed By: Rehan Javed");
		lblDevelopedByRehan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevelopedByRehan.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblDevelopedByRehan.setBounds(6, 317, 490, 16);
		contentPane.add(lblDevelopedByRehan);
		
		title = new JLabel("Guess the Right Card (2 - 10)");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(6, 6, 490, 16);
		contentPane.add(title);
		
		sumLabel = new JLabel("Sum:");
		sumLabel.setBounds(6, 50, 50, 16);
		contentPane.add(sumLabel);
		
		sum = new JTextField();
		sum.setBounds(68, 45, 103, 26);
		contentPane.add(sum);
		sum.setColumns(10);
		
		productLabel = new JLabel("Product:");
		productLabel.setBounds(183, 50, 67, 16);
		contentPane.add(productLabel);
		
		product = new JTextField();
		product.setBounds(258, 45, 103, 26);
		contentPane.add(product);
		product.setColumns(10);
		
		cards = new JButton("Cards");
		cards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon. by RJ APPS");
			}
		});
		cards.setBounds(373, 45, 117, 29);
		contentPane.add(cards);
		
		findCards = new JButton("Find Cards");
		findCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Find Cards
				findCards();
				
			}
		});
		findCards.setBounds(0, 78, 361, 29);
		contentPane.add(findCards);
		
		result = new JLabel("Result  ==>> ");
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBounds(6, 289, 492, 16);
		contentPane.add(result);
		
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//resetting..
				sum.setText("");
				product.setText("");
				for(JLabel label: card)
					label.setIcon(new ImageIcon("cards/0.png"));
				
			}
		});
		reset.setBounds(373, 78, 117, 29);
		contentPane.add(reset);
		
	}
	
}
