package com.unigranrio.tcc.model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.unigranrio.tcc.model.ConquistaBean;
import com.unigranrio.tcc.model.ProgressoBean;
import com.unigranrio.tcc.model.UsuarioBean;

@Entity
@NamedQueries({
		@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "Usuario.getPosicao", query = "SELECT COUNT(*) FROM Usuario u WHERE u.pontos > :pontos"),
		@NamedQuery(name = "Usuario.listByPontuacao", query = "SELECT u FROM Usuario u "
				+ "ORDER BY u.pontos DESC"),
		@NamedQuery(name = "Usuario.updatePontos", query = "UPDATE Usuario u SET u.pontos = :pontos WHERE u.login = :login"),
		@NamedQuery(name = "Usuario.updateProgresso", query = "UPDATE Usuario u SET u.posicao = :posicao WHERE u.login = :login"),
		@NamedQuery(name = "Usuario.allBadges", query = "SELECT u.badges FROM Usuario u WHERE u.login = :login"),
		@NamedQuery(name = "Usuario.deleteConquistas", query = "DELETE FROM Usuario u WHERE u.badges = :badges"),
})
public class Usuario {

	@Column(nullable = false)
	private String nome;

	@Id
	private String login;

	@Column(nullable = false)
	private String senha;

	@ManyToOne(optional = false)
	private Nivel nivel;

	@Column(nullable = false)
	private int pontos;

	private int posicao;

	@OneToMany(mappedBy = "usuario")
	private Collection<Conquista> badges;

	@OneToMany
	private List<Progresso> progressos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Collection<Conquista> getBadges() {
		return badges;
	}

	public void setBadges(Collection<Conquista> badges) {
		this.badges = badges;
	}

	public List<Progresso> getProgressos() {
		return progressos;
	}

	public void setProgressos(List<Progresso> progressos) {
		this.progressos = progressos;
	}

	public List<ConquistaBean> getBadgesBean() {
		List<ConquistaBean> badgesBean = new ArrayList<ConquistaBean>();
		for (Conquista badge : badges) {
			ConquistaBean conquistaBean = badge.getConquistaBean();

			badgesBean.add(conquistaBean);
		}

		return badgesBean;
	}

	public List<ProgressoBean> getProgressosBean() {
		List<ProgressoBean> progressosBean = new ArrayList<ProgressoBean>();
		for (Progresso progresso : progressos) {
			ProgressoBean progressoBean = progresso.getProgressoBean();

			progressosBean.add(progressoBean);
		}

		return progressosBean;
	}

	public UsuarioBean getUsuarioBean() {
		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean.setNome(nome);
		usuarioBean.setLogin(login);
		usuarioBean.setPontos(pontos);
		usuarioBean.setSenha(senha);
		usuarioBean.setNivel(nivel.getNivelBean());
		usuarioBean.setPosicao(posicao);

		return usuarioBean;

	}

}
