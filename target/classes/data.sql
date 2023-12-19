INSERT INTO tb_usuario (first_name, last_name, email, password) VALUES ('Fufu', 'Brown', 'fufu@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario (first_name, last_name, email, password) VALUES ('Maria', 'Joana', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 2);


INSERT INTO tb_empresa (cnpj, nome) VALUES ('88.888.888/0001-88', 'IFPB');
INSERT INTO tb_empresa (cnpj, nome) VALUES ('55.555.555/0005-55', 'Google');
INSERT INTO tb_empresa (cnpj, nome) VALUES ('22.333.999/0009-11', 'UFCG');

INSERT INTO tb_orientador (matricula, nome) VALUES ('123456', 'Cristiano');
INSERT INTO tb_orientador (matricula, nome) VALUES ('654123', 'Daladier');
INSERT INTO tb_orientador (matricula, nome) VALUES ('444444', 'Alguem sem aluno');

INSERT INTO 
  tb_aluno (curso, matricula, nome, empresa_aluno_id, orientador_aluno_id)
  VALUES ('ADS', '981834', 'Túlio', 1, 1);
INSERT INTO 
  tb_aluno (curso, matricula, nome, empresa_aluno_id, orientador_aluno_id)
  VALUES ('ADS', '142673', 'Iago', 2, 1);
INSERT INTO 
  tb_aluno (curso, matricula, nome, empresa_aluno_id, orientador_aluno_id)
  VALUES ('ADS', '746613', 'Matheus', 2, 2);

INSERT INTO 
  tb_estagio (carga_horaria, data_fim, data_inicio, status, aluno_estagio_id, empresa_estagio_id, orientador_estagio_id)
  VALUES ('30', '14/07/2023', '14/06/2023', 'concluído', 1, 1, 1);
INSERT INTO 
  tb_estagio (carga_horaria, data_fim, data_inicio, status, aluno_estagio_id, empresa_estagio_id, orientador_estagio_id)
  VALUES ('30', '15/12/2023', '15/01/2024', 'em andamento', 2, 2, 2);

INSERT INTO
  tb_avaliacao_da_empresa (aprendizagem, conhecimentos, cumprimento_das_tarefas, desempenho, rendimento_de_trabalho, aluno_id, empresa_id)
  VALUES ('Muito Bom', 'Bom', 'Regular', 'Insuficiente', 'Bom', 1, 1);
INSERT INTO
  tb_avaliacao_da_empresa (aprendizagem, conhecimentos, cumprimento_das_tarefas, desempenho, rendimento_de_trabalho, aluno_id, empresa_id)
  VALUES ('Bom', 'Regular', 'Muito Bom', 'Regular', 'Bom', 2, 2);

INSERT INTO
  tb_avaliacao_do_professor (assiduidade, disciplina, iniciativa, responsabilidade, sociabilidade, aluno_id, orientador_id)
  VALUES('Muito Bom', 'Regular', 'Insuficiente', 'Bom', 'Bom', 1, 1);
INSERT INTO
  tb_avaliacao_do_professor (assiduidade, disciplina, iniciativa, responsabilidade, sociabilidade, aluno_id, orientador_id)
  VALUES('Bom', 'Muito Bom', 'Regular', 'Regular', 'Bom', 2, 2);