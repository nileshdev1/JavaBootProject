package org.nk.service;

import java.util.List;
import java.util.Optional;

import org.nk.model.Document;

public interface IDocumentService {

	public void saveDocument(Document doc);
	public List<Object[]> findIdAndName();
	public Optional<Document> findDocument(Integer id);
}
