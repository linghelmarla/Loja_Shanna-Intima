package com.loja.shannaIntima.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.shannaIntima.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	public Optional<Usuario> findByid(Long id);

	public Optional<Usuario> findByUsuario(String usuario);

	public Optional<Usuario> findByNome(String nome);
}
