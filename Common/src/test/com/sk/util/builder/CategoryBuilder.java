package com.sk.util.builder;import com.sk.domain.Category;public class CategoryBuilder extends BaseBuilder<Category, CategoryBuilder> {	@Override	protected Category doBuild() {		Category category = new Category();		return category;	}}