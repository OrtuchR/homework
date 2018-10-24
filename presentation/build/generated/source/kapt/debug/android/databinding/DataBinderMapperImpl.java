package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.gmail.ortuchr.homework.DataBinderMapperImpl());
  }
}
