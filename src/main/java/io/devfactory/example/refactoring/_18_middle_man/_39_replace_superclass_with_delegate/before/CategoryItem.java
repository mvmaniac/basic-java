package io.devfactory.example.refactoring._18_middle_man._39_replace_superclass_with_delegate.before;

import java.util.List;

public class CategoryItem {

  private final Integer id;
  private final String title;
  private final List<String> tags;

  public CategoryItem(Integer id, String title, List<String> tags) {
    this.id = id;
    this.title = title;
    this.tags = tags;
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public boolean hasTag(String tag) {
    return this.tags.contains(tag);
  }

}
