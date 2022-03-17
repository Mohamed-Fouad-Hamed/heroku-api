package alf.api.web.repository;

import java.util.List;

public interface ISearchLikeName<T> {

	List<T> listLikeName(String name);

}