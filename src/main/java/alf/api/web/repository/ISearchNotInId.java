package alf.api.web.repository;

import java.util.List;

public interface ISearchNotInId<T> {
	List<T> listNotInId(Long id);

}
